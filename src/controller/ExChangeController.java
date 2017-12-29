package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import po.Exchange;
import po.Item;
import po.User;
import service.ExchangeDao;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item")
public class ExChangeController {

	@Autowired
	private ExchangeDao ed;

	/**
	 * 商品交换信息提交
	 * 
	 * @param exc
	 *            po类对象，前台传值为：gid_a,gid_b,info
	 *            date,uid_a,uid_b通过控制器获取并赋值，statu="submit";
	 * @return 成功插入到数据库中则返回交换单id
	 */
	@RequestMapping("/itemExc")
	public @ResponseBody String itemExc(Exchange exc, HttpSession session) {
		/*
		 * char[] a = exc.getGid_a().toCharArray(); char[] b =
		 * exc.getGid_b().toCharArray(); char[] c = new char[17]; for (int i = 0; i <
		 * 17; i++) { c[i] = (char) (a[i] + b[i]); System.out.println("c"+i+":"+c[i]); }
		 * exc.setId(new String(c));
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = new Date();
		exc.setId(sdf.format(d) + new Random().nextInt(1000));
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		exc.setDate(sdf.format(d));
		exc.setStatu("submit");
		exc.setUid_a(((User) session.getAttribute("user")).getUsername());
		exc.setUid_b(((Item) session.getAttribute("itemdata")).getUid());
		ed.addExc(exc);
		return exc.getId();
	}

	/**
	 * 获取交换请求列表
	 */
	@RequestMapping(value = "/getRequested", produces = "text/plain;charset=utf-8")
	public String getRequestedExchange(HttpSession session) {
		return JSON.toJSONString(ed.getMyExc("uid_b", ((User) session.getAttribute("user")).getUsername()));
	}

	/**
	 * 用户处理请求
	 * 
	 * @param id
	 *            交换单id
	 * @param info
	 *            success:同意交换 fail:不同意交换
	 * @return
	 */
	@RequestMapping("/isExchange")
	public @ResponseBody String exchangeSuccess(String id, String info, HttpSession session) {
		Map<String, String> m = new HashMap<>();
		m.put("id", id);
		m.put("statu", info);
		if (ed.changeExc(m).equals("FALSE"))
			return "fail";
		return "success";
	}

	/**
	 * 获取用户提交的交换请求信息
	 */
	@RequestMapping(value = "/getExchange", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String getSubmitExchange(HttpSession session, @RequestParam("type")String type) {
		/*
		 * Map<String, String> map = new HashMap<>(); map.put("uid_a",
		 * ((User)session.getAttribute("user")).getUsername());
		 */
		if (type.equals("submit")) {
			return JSON.toJSONString(ed.getMyExc(((User) session.getAttribute("user")).getUsername(), "%"));
		} else if (type.equals("request"))
			return JSON.toJSONString(ed.getMyExc("%", ((User) session.getAttribute("user")).getUsername()));
		return "";
	}

	/**
	 * 
	 * @param excId
	 *            交换单号
	 * @return 一个ExcData（model包中）对象构造的JSON字符串
	 */
	@RequestMapping(value = "/getExcData", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String getExcData(@RequestParam("excId") String excId) {
		return JSON.toJSONString(ed.getExcAllDate(excId));
	}
	
	@RequestMapping("/removeExc")
	public @ResponseBody String remove(@RequestParam("excId") String excId) {
		
		return ed.deleteExc(excId);
	}
	

	public void setEd(ExchangeDao ed) {
		this.ed = ed;
	}
}
