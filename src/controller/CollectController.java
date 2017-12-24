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
	 * @return ��ȡ�ղ����������Ʒ(���ܲ������)
	 */
	@RequestMapping("/getRecommend")
	public @ResponseBody List<Item> getRecommend(){
		return i.getPopular();
	}


	/**
	 * 
	 * @param ��Ʒ�ղأ�ǰ̨�ṩ��Ʒid�����ز������(success/false)
	 */
	@RequestMapping("/collect")
	public @ResponseBody String collect(@RequestParam("itemid") String itemid, HttpSession session) {
		Collect c = new Collect(((User) session.getAttribute("user")).getUsername(), itemid);
		if (collectd.addCollect(c) != 0)
			return "success";
		return "false";
	}

	/**
	 * ȡ���ղ�
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
	 *            �û����û���
	 * @return ��Ʒ�ղر�
	 */
	@RequestMapping("/getCollect")
	public @ResponseBody List<Collect> getCollect(String username) {
		return collectd.findCollect(username);
	}

	/**
	 * �ж��û��Ƿ��ղظ���Ʒ
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
