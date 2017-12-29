package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import po.Message;
import po.User;
import service.MessageDaoImpl;

@Controller
public class MessageController {

	@Autowired
	private MessageDaoImpl msgDao;

	/**
	 * 接收消息
	 * 
	 * @param username
	 *            用户id
	 * @return
	 */
	@RequestMapping(value = "/getMessage", produces = "text/plain;charset=utf-8")
	public @ResponseBody String getMessage(HttpSession session) {
		String username = ((User) session.getAttribute("user")).getUsername();
		Map<String, String> p = new HashMap<>();
		p.put("usernameB", username);
		return JSON.toJSONString(msgDao.getMessage(p));
	}

	/**
	 * 信息被读过之后,修改状态
	 * 
	 * @param m
	 *            消息
	 * @return
	 */
	@RequestMapping("/changeMessage")
	public @ResponseBody void changeMessage(Message m) {
		m.setStatu(1);
		msgDao.changeMessage(m);
	}

	public void setMsgDao(MessageDaoImpl msgDao) {
		this.msgDao = msgDao;
	}

	@RequestMapping("/deleteMsg")
	public @ResponseBody String deleteMsg(String excId) {
		int i = msgDao.deletMessage(excId);
		if (i > 0)
			return "s";
		else
			return "f";
	}
	
	@RequestMapping("/unread")
	public @ResponseBody String unread(HttpSession session) {
		String username = ((User) session.getAttribute("user")).getUsername();
		return ""+msgDao.unread(username);
		
	}

}
