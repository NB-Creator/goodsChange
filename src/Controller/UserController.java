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
			// 将查询到的user信息保存并传给主页面
			Map<String, String> m = new HashMap<String, String>();
			m.put("username", username);
			user = u.getUser(m);
			model.addAttribute("user", user);
			// 设置登录成功路径

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
		p.put("classification", "手机");
		itemlist = itemDao.find(p);
		model.addAttribute("phonelist", itemlist);
		p.put("classification", "电脑");
		itemlist = itemDao.find(p);
		model.addAttribute("computerlist", itemlist);
		p.put("classification", "书籍");
		model.addAttribute("booklist", itemlist);
		p.put("classification", "衣物");
		model.addAttribute("clothinglist", itemlist);
		p.put("classification", "运动");
		model.addAttribute("sportlist", itemlist);
		p.put("classification", "游戏");
		model.addAttribute("gamelist", itemlist);
		p.put("classification", "原创");
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
	 * @param uMap 包含用户提交的修改数据键值，除了username的其它属性，以及一个旧密码oldpassword
	 * 用来在用户修改密码时对原密码的验证，若不匹配，则不更新信息并返回'oldpasserro'，（即当key=password不为空时需判定oldpassword）
	 * @return 更新成功返回success
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
