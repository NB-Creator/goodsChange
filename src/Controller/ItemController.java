package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import po.Exchange;
import po.Item;
import po.User;
import service.ItemDao;
import service.UserDao;

@Controller
@SessionAttributes(value = { "user", "additem", "itemdata" })
public class ItemController {

	@Autowired
	private ItemDao i;
	@Autowired
	private UserDao u;

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
		model.addAttribute("b_itemlist", i.find(p).get(0));
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
	public String exchangePage(@ModelAttribute("itemdata") Item item, Model model) {
		model.addAttribute("excitem", item);
		//�����
		return "itemPage/excPage";
	}
	
	
	/**
	 * ��Ʒ������Ϣ�ύ
	 * @param exc po�����ǰ̨��ֵΪ��gid_a,gid_b,info
	 * date,uid_a,uid_bͨ����������ȡ����ֵ��statu="�ύ";
	 * @return �ɹ����뵽���ݿ����򷵻�"success",�����򷵻���Ӧ�Ĵ�����Ϣ
	 */
	@RequestMapping("/itemExc")
	public @ResponseBody String itemExc(Exchange exc) {
		//�����
		return "";
	}
	
	
	public void setI(ItemDao i) {
		this.i = i;
	}

	public void setU(UserDao u) {
		this.u = u;

	}
}
