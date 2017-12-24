package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	public @ResponseBody String itemExc(Exchange exc,HttpSession session) {
		/*char[] a = exc.getGid_a().toCharArray();
		char[] b = exc.getGid_b().toCharArray();
		char[] c = new char[17];
		for (int i = 0; i < 17; i++) {
			c[i] = (char) (a[i] + b[i]);
			System.out.println("c"+i+":"+c[i]);
		}
		exc.setId(new String(c));*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = new Date();
		exc.setId(sdf.format(d) + new Random().nextInt(1000));
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		exc.setDate(sdf.format(d));
		exc.setStatu("submit");
		exc.setUid_a(((User)session.getAttribute("user")).getUsername());
		exc.setUid_b(((Item)session.getAttribute("itemdata")).getUid());
		ed.addExc(exc);
		return exc.getId();
	}


	@RequestMapping("/getExchange")
	public List<Exchange> getExchange(HttpSession session){
		Map<String, String> map = new HashMap<>();
		map.put("uid_a", ((User)session.getAttribute("user")).getUsername());
		return ed.selectExc(map);
	}
	
	/**
	 * 
	 * @param excId
	 *            交换单号
	 * @return 一个ExcData（model包中）对象构造的JSON字符串
	 */
	@RequestMapping(value="/getExcData",produces="text/plain;charset=UTF-8")
	public @ResponseBody String getExcData(@RequestParam("excId") String excId) {
		return JSON.toJSONString(ed.getExcAllDate(excId));
	}

	public void setEd(ExchangeDao ed) {
		this.ed = ed;
	}
}
