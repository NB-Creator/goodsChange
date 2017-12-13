package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import po.Collect;
import po.Comment;
import po.Exchange;
import po.Item;
import po.User;
import service.CollectDao;
import service.CommentDao;
import service.ExchangeDao;
import service.ItemDao;
import service.UserDao;

@Controller
@SessionAttributes(value = { "user", "additem", "itemdata" })
public class ItemController {

	@Autowired
	private ItemDao i;
	@Autowired
	private UserDao u;
	@Autowired
	private ExchangeDao ed;
	@Autowired
	private CollectDao collectd;
	@Autowired
	private CommentDao commentd;

	@RequestMapping("/addItemPage")
	public String addItemPage() {
		return "itemPage/addItem";
	}
	
	@RequestMapping("/myCollectPage")
	public String myCollectPage() {
		return "itemPage/myCollectPage";
	}
	
	@RequestMapping("/mySubmitPage")
	public String mySubmitPage() {
		return "itemPage/mySubmitPage";
	}
	

	@RequestMapping("/myItem")
	public String myItem() {
		return "itemPage/myItemPage";
	}
	
	@RequestMapping("/businessPage")
	public String business() {
		return "itemPage/businessPage";
	}
	
	
	@RequestMapping("/addSuccessPage")
	public String addSuccess(@ModelAttribute("additem") Item item, Model model) {
		model.addAttribute("additem", item);
		return "itemPage/addSuccessPage";
	}

	@RequestMapping("/uploadItem")
	public @ResponseBody String upload(Model model, Item item) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = new Date();
		item.setId(sdf.format(d) + new Random().nextInt(1000));
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		item.setTime(sdf.format(d));
		item.setUid(((User) model.asMap().get("user")).getUsername());

		boolean flag = i.upload(item);
		if (flag == false)
			return "FALSE";
		else {
			Map<String, String> p = new HashMap<String, String>();
			p.put("id", item.getId());
			item = i.find(p).get(0);
			model.addAttribute("additem", item);
			return "success";
		}
	}

	public ModelAndView down(ModelAndView mv, Item item) {
		boolean flag = i.down(item);
		if (flag == false)
			mv.setViewName("downSuccess.jsp");
		else
			mv.setViewName("downFalse.jsp");
		return mv;
	}

	public ModelAndView change(ModelAndView mv, Item item) {
		Map<String, String> p = new HashMap<>();

		if (item.getName() != null)
			p.put("name", item.getName());
		if (item.getClassification() != null)
			p.put("classification", item.getClassification());
		if (item.getPrice() != null)
			p.put("price", String.valueOf(item.getPrice()));
		if (item.getExpect() != null)
			p.put("execpt", item.getExpect());
		if (item.getDetail() != null)
			p.put("detail", item.getDetail());
		if (item.getImg() != null)
			p.put("img", item.getImg());

		i.change(p);
		mv.setViewName("changeSuccess.jsp");
		return mv;
	}

	/**
	 * 
	 * @param 查询条件map
	 * @return 查询到的商品列表的json字符串
	 */
	@RequestMapping(value = "/getItemList")
	public @ResponseBody String find(@RequestBody Map<String, String> p) {
		return JSON.toJSONString(i.find(p));
	}

	/**
	 * 
	 * @param id为商品id
	 *            将该商品查询出来添加到model中key="itemdata",
	 *            将该商品的所有者信息查询出来添加到model,key="user_b"
	 *            添加一个user_b的所有商品列表到model,key="b_itemlist"//11月21日新增
	 * @return 商品详情页面
	 */
	@RequestMapping("/itemPage/itemid={id}")
	public String geturlparam(@PathVariable("id") String id, Model model) {
		Map<String, String> p = new HashMap<>();
		p.put("id", id);
		Item item = i.find(p).get(0);
		model.addAttribute("itemdata", item);
		p.clear();
		p.put("username", item.getUid());
		User user=u.getUser(p);
		model.addAttribute("user_b" , user);
		p.clear();
		p.put("uid", user.getUsername());
		model.addAttribute("b_itemlist", i.find(p));
		return "itemPage/itemPage";
	}

	
	/**
	 *请求商品交换页面 
	 * @param item
	 * @param model
	 * model中还需要添加一个用户的所有发布的，且状态为"空闲"的商品列表
	 * @return
	 */
	@RequestMapping("/excPage")
	public String exchangePage(@ModelAttribute("itemdata") Item item, HttpSession session, Model model) {
		Map<String,String> m=new HashMap<>();
		m.put("gid_a", item.getId());
		//当前商品已经用于交换
		if(ed.selectExc(m).isEmpty()){
			
		}else{
			m.replace("gid_a", "gid_b");
			if(ed.selectExc(m).isEmpty()) {
				
			}
				
		}
		/*m.clear();
		m.put("uid", ((User)session.getAttribute("user")).getUsername());*/
		model.addAttribute("excitem", item);
		return "itemPage/excPage";
	}
	
	
	/**
	 * 商品交换信息提交
	 * @param exc po类对象，前台传值为：gid_a,gid_b,info
	 * date,uid_a,uid_b通过控制器获取并赋值，statu="submit";
	 * @return 成功插入到数据库中则返回"success",其它则返回相应的错误信息
	 */
	@RequestMapping("/itemExc")
	public @ResponseBody String itemExc(Exchange exc) {
		char[] a=exc.getGid_a().toCharArray();
		char[] b=exc.getGid_b().toCharArray();
		char[] c=new char[17];
		for(int i=0;i<17;i++)
			c[i]=(char) (a[i]+b[i]);
		exc.setId(new String(c));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = new Date();
		exc.setDate(sdf.format(d));
		exc.setStatu("submit");
		ed.addExc(exc);
		return "success";
	}
	
	/**
	 * 
	 * @param 商品收藏，前台提供商品id，返回操作结果(success/false)
	 */
	@RequestMapping("/collect")
	public @ResponseBody String collect(@RequestParam("itemid")String itemid,HttpSession session) {
		Collect c=new Collect(((User)session.getAttribute("user")).getUsername(),itemid);
		if(collectd.addCollect(c)!=0)
			return "success";
		return "false";
	}
	
	/**
	 * 取消收藏
	 */
	@RequestMapping("/cancelCollect")
	public @ResponseBody String cancelCollect(@RequestParam("itemid")String itemid,HttpSession session) {
		String uid=((User)session.getAttribute("user")).getUsername();
		if(collectd.deleteCollect(uid, itemid)!=-1)
			return "success";
		return "false";
	}
	
	/**
	 * 
	 * @param 商品评论，前台提供g_id,info,u_id,后台获取时间
	 */
	@RequestMapping("/comment")
	public @ResponseBody String comment(Comment comment) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date(System.currentTimeMillis());
		comment.setDate(sdf.format(date));
		if(commentd.addComment(comment)!=0)
			return"success";
		return "false";
	}
	
	/**
	 * 
	 * @param 获取商品评论列表
	 * @return 该商品的评论列表
	 */
	@RequestMapping("/getComment")
	public @ResponseBody String getComment(@RequestParam("itemid")String itemid) {
		List<Comment> commentList = commentd.findComment(itemid);
		return JSON.toJSONString(commentList);
	}
	
	/**
	 * 判断用户是否收藏该商品
	 * @param itemid
	 * @param session
	 * @return 
	 */
	@RequestMapping("/isCollect")
	public @ResponseBody String isCollect(@RequestParam("itemid")String itemid,HttpSession session) {
		
		String uid=((User)session.getAttribute("user")).getUsername();
		if(collectd.select(uid, itemid).size()>0)
			return "exist";
		return "no";
	}
	public void setI(ItemDao i) {
		this.i = i;
	}

	public void setU(UserDao u) {
		this.u = u;
	}

	public void setEd(ExchangeDao ed) {
		this.ed = ed;
	}

	public void setCollectd(CollectDao collectd) {
		this.collectd = collectd;
	}

	public void setCommentd(CommentDao commentd) {
		this.commentd = commentd;
	}
	
}
