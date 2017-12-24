package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Collect;
import po.Item;
import po.User;
import service.CollectDao;
import service.ItemDao;

public class CollectController {


	@Autowired
	private CollectDao collectd;
	
	@Autowired
	private ItemDao i;
	
	/**
	 * @return 获取收藏最多的五个商品(可能不足五个)
	 */
	@RequestMapping("/getRecommend")
	public @ResponseBody List<Item> getRecommend(){
		return i.getPopular();
	}


	/**
	 * 
	 * @param 商品收藏，前台提供商品id，返回操作结果(success/false)
	 */
	@RequestMapping("/collect")
	public @ResponseBody String collect(@RequestParam("itemid") String itemid, HttpSession session) {
		Collect c = new Collect(((User) session.getAttribute("user")).getUsername(), itemid);
		if (collectd.addCollect(c) != 0)
			return "success";
		return "false";
	}

	/**
	 * 取消收藏
	 */
	@RequestMapping("/cancelCollect")
	public @ResponseBody String cancelCollect(@RequestParam("itemid") String itemid, HttpSession session) {
		String uid = ((User) session.getAttribute("user")).getUsername();
		if (collectd.deleteCollect(uid, itemid) != -1)
			return "success";
		return "false";
	}

	/**
	 * @param username
	 *            用户的用户名
	 * @return 商品收藏表
	 */
	@RequestMapping("/getCollect")
	public @ResponseBody List<Collect> getCollect(String username) {
		return collectd.findCollect(username);
	}

	/**
	 * 判断用户是否收藏该商品
	 * 
	 * @param itemid
	 * @param session
	 * @return
	 */
	@RequestMapping("/isCollect")
	public @ResponseBody String isCollect(@RequestParam("itemid") String itemid, HttpSession session) {

		String uid = ((User) session.getAttribute("user")).getUsername();
		if (collectd.select(uid, itemid).size() > 0)
			return "exist";
		return "no";
	}


	public void setCollectd(CollectDao collectd) {
		this.collectd = collectd;
	}


	public void setI(ItemDao i) {
		this.i = i;
	}

}
