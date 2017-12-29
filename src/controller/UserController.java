package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;

import po.Item;
import po.User;
import po.UserRole;
import security.MyUserDetail;
import service.ItemDao;
import service.UserDao;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserDao u;
	@Autowired
	private ItemDao itemDao;

	@RequestMapping(value = "/loginPage")
	public String loginPage(Model model) {
		// System.out.println("123");
		return "userPage/loginPage";
	}

	
	/*@RequestMapping("/login")
	public @ResponseBody String login(String username, String password, Model model) {

		User user = new User(username, password);
		String msg = u.login(user);
		if ("SUCCESS".equals(msg)) {
			// ����ѯ����user��Ϣ���沢������ҳ��
			Map<String, String> m = new HashMap<String, String>();
			m.put("username", username);
			user = u.getUser(m);
			model.addAttribute("user", user);
			// ���õ�¼�ɹ�·��

			return msg;
		} else {
			return msg;
		}
	}*/

	//�û���֤�ɹ�����
		@RequestMapping("/loginSuccess")
		public @ResponseBody String login(@RequestParam("url") String url, Model model, HttpServletRequest request) {
			//��ȡ�û�Ȩ����Ϣʵ��
			MyUserDetail userDetails = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserRole myUser = userDetails.getMyUser();
			
			//��ӵ�ǰ�û�ʵ����session
			Map<String, String> m = new HashMap<String, String>();
			m.put("username", myUser.getUsername());
			User user = u.getUser(m);
			model.addAttribute("user", user);
			
			//����ajax������Ϣ
			Map<String, String> map = new HashMap<String, String>();
			map.put("success", "true");
			map.put("url", url);
			return JSON.toJSONString(map);
			
		}

		//�û���֤ʧ�ܲ���
		@RequestMapping(value = "/login/failure", produces = "text/plain;charset=UTF-8")
		public @ResponseBody String failure() {
			Map<String, String> map = new HashMap<String, String>();
			map.put("success", "false");
			map.put("msg", "�˻������������");
			return JSON.toJSONString(map);
		}
	
	@RequestMapping("/mainPage")
	public String loginSuccess(Model model) {
		Map<String, String> p = new HashMap<String, String>();
		List<Item> itemlist = itemDao.find(p);
		model.addAttribute("newlist", itemlist);
		p.put("classification", "�ֻ�");
		itemlist = itemDao.find(p);
		model.addAttribute("phonelist", itemlist);
		p.put("classification", "����");
		itemlist = itemDao.find(p);
		model.addAttribute("computerlist", itemlist);
		p.put("classification", "�鼮");
		model.addAttribute("booklist", itemlist);
		p.put("classification", "����");
		model.addAttribute("clothinglist", itemlist);
		p.put("classification", "�˶�");
		model.addAttribute("sportlist", itemlist);
		p.put("classification", "��Ϸ");
		model.addAttribute("gamelist", itemlist);
		p.put("classification", "ԭ��");
		model.addAttribute("originalitylist", itemlist);
		return "main";
	}

	@RequestMapping(value = "/registerPage")
	public String registerPage(Model model) {
		return "userPage/registerPage";
	}

	@RequestMapping("/register")
	public @ResponseBody String resgiter(User user) {
		return u.register(user);
	}

	/**
	 * 
	 * @param uMap
	 *            �����û��ύ���޸����ݼ�ֵ������username���������ԣ��Լ�һ��������oldpassword
	 *            �������û��޸�����ʱ��ԭ�������֤������ƥ�䣬�򲻸�����Ϣ������'oldpasserro'��������key=password��Ϊ��ʱ���ж�oldpassword��
	 * @return ���³ɹ�����success
	 */
	@RequestMapping("/admin/changeInfo")
	public @ResponseBody String changeInfo(@RequestBody Map<String, Object> uMap,Model model) {
		Map<String, Object> m = new HashMap<>();
		Map<String, Object> p = uMap;
		m.put("username", p.get("username"));
		if (p.get("nickname") != "")
			m.put("nickname", p.get("nickname"));
		if (p.get("mail") != "")
			m.put("mail", p.get("mail"));
		if (p.get("name") != "")
			m.put("name", p.get("name"));
		if (p.get("password") != "") {
			if (p.get("oldpassword") != null) {
				String msg = u.login(new User((String) p.get("username"), (String) p.get("oldpassword")));
				if (msg.equals("FALSE"))
					return "oldpasserro";
				m.put("password", p.get("password"));
			}
		}
		u.changeInfo(m);
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("username", (String) p.get("username"));
		model.addAttribute("user", u.getUser(m1));
		return "success";
	}
	public void setU(UserDao u) {
		this.u = u;
	}

	@RequestMapping("/userQuit")
	public String userQuit(Model model) {
		model.addAttribute("user", new User());
		return "userPage/loginPage";
	}
	
	@RequestMapping("/admin/excData")
	public String excData() {
		return "itemPage/excData";
	}

}
