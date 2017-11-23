package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import po.Item;
import po.User;
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
		//System.out.println("123");
		return "userPage/loginPage";
	}

	@RequestMapping("/login")
	public @ResponseBody String login(String username, String password,
			Model model) {

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
		String msg = u.register(user);
		return msg;

	}

	/**
	 * 
	 * @param uMap �����û��ύ���޸����ݼ�ֵ������username���������ԣ��Լ�һ��������oldpassword
	 * �������û��޸�����ʱ��ԭ�������֤������ƥ�䣬�򲻸�����Ϣ������'oldpasserro'��������key=password��Ϊ��ʱ���ж�oldpassword��
	 * @return ���³ɹ�����success
	 */
	@RequestMapping("/changeInfo")
	public @ResponseBody String changeInfo(Map<String,Object> uMap) {
		Map<String, Object> m = new HashMap<>();
		Map<String, Object> p = uMap;
		if (p.get("nickname") != null)
			m.put("nickname", p.get("nickname"));
		if (p.get("mail") != null)
			m.put("mail", p.get("mail"));
		if (p.get("name") != null)
			m.put("name", p.get("name"));
		if (p.get("password") != null){
			if(p.get("oldpassword") != null){
				String msg = u.login(new User((String)p.get("username"),(String)p.get("oldpassword")));
				if(msg.equals("FALSE"))
					return "oldpasserro";
				m.put("password", p.get("password"));
			}
		}
		u.changeInfo(p);
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

	@RequestMapping("userMainPage")
	public String userMainPage() {
		return "userPage/userMainPage";
	}

}
