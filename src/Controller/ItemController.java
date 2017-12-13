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
	 * @param ��ѯ����map
	 * @return ��ѯ������Ʒ�б��json�ַ���
	 */
	@RequestMapping(value = "/getItemList")
	public @ResponseBody String find(@RequestBody Map<String, String> p) {
		return JSON.toJSONString(i.find(p));
	}

	/**
	 * 
	 * @param idΪ��Ʒid
	 *            ������Ʒ��ѯ������ӵ�model��key="itemdata",
	 *            ������Ʒ����������Ϣ��ѯ������ӵ�model,key="user_b"
	 *            ���һ��user_b��������Ʒ�б�model,key="b_itemlist"//11��21������
	 * @return ��Ʒ����ҳ��
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
	 *������Ʒ����ҳ�� 
	 * @param item
	 * @param model
	 * model�л���Ҫ���һ���û������з����ģ���״̬Ϊ"����"����Ʒ�б�
	 * @return
	 */
	@RequestMapping("/excPage")
	public String exchangePage(@ModelAttribute("itemdata") Item item, HttpSession session, Model model) {
		Map<String,String> m=new HashMap<>();
		m.put("gid_a", item.getId());
		//��ǰ��Ʒ�Ѿ����ڽ���
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
	 * ��Ʒ������Ϣ�ύ
	 * @param exc po�����ǰ̨��ֵΪ��gid_a,gid_b,info
	 * date,uid_a,uid_bͨ����������ȡ����ֵ��statu="submit";
	 * @return �ɹ����뵽���ݿ����򷵻�"success",�����򷵻���Ӧ�Ĵ�����Ϣ
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
	 * @param ��Ʒ�ղأ�ǰ̨�ṩ��Ʒid�����ز������(success/false)
	 */
	@RequestMapping("/collect")
	public @ResponseBody String collect(@RequestParam("itemid")String itemid,HttpSession session) {
		Collect c=new Collect(((User)session.getAttribute("user")).getUsername(),itemid);
		if(collectd.addCollect(c)!=0)
			return "success";
		return "false";
	}
	
	/**
	 * ȡ���ղ�
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
	 * @param ��Ʒ���ۣ�ǰ̨�ṩg_id,info,u_id,��̨��ȡʱ��
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
	 * @param ��ȡ��Ʒ�����б�
	 * @return ����Ʒ�������б�
	 */
	@RequestMapping("/getComment")
	public @ResponseBody String getComment(@RequestParam("itemid")String itemid) {
		List<Comment> commentList = commentd.findComment(itemid);
		return JSON.toJSONString(commentList);
	}
	
	/**
	 * �ж��û��Ƿ��ղظ���Ʒ
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
