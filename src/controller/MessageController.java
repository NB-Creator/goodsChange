package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import po.Message;
import service.MessageDaoImpl;

@Controller
public class MessageController {

	@Autowired
	private MessageDaoImpl msgDao;
	
	/**
	 * 接收消息
	 * 
	 * @param username 用户id
	 * @return
	 */
	@RequestMapping("/getMessage")
	public @ResponseBody String getMessage(String username){
		Map<String, String> p=new HashMap<>();
		p.put("usernameB", username);
		return JSON.toJSONString(msgDao.getMessage(p));
	}

	
	/**
	 * 信息被读过之后,修改状态
	 * 
	 * @param m 消息
	 * @return
	 */
	@RequestMapping("/changeMessage")
	public int changeMessage(Message m){
		m.setStatus(1);
		return msgDao.changeMessage(m);
	}

	public void setMsgDao(MessageDaoImpl msgDao) {
		this.msgDao = msgDao;
	}
	
}
