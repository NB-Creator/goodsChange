package Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import po.User;
import service.UserDao;

@Controller("/user")
public class UserController {

	@Autowired
	private UserDao u;
	
	@RequestMapping("/login")
	public ModelAndView login(String username,String password,ModelAndView mv){
		User user=new User(username, password);
		String msg = u.login(user);
		if("SUCCESS".equals(msg)){
			//将查询到的user信息保存并传给主页面
			mv.addObject("user", user);
			//设置登录成功路径
			mv.setViewName("main.jsp");
		}else
			mv.setViewName("loginFalse.jsp");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView resgiter(User user,ModelAndView mv){
		String msg=u.register(user);
		if(!msg.equals("SUCCESS")){
			//注册不成功
			mv.setViewName("registFalse.jsp");
			//错误信息
			mv.addObject("msg", msg);
		}
		else{
			//注册成功
			mv.setView("login.jsp");
			mv.addObject("user",user);
		}
		return mv;
	}
	
	@RequestMapping("/changeInfo")
	public ModelAndView changeInfo(ModelAndView mv){
		Map<String, Object> m=new HashMap<>();
		Map<String, Object> p=mv.getModel();
		if(p.get("nickname")!=null)
			m.put("nickname", p.get("nickname"));
		if(p.get("password")!=null)
			m.put("password", p.get("password"));
		if(p.get("mail")!=null)
			m.put("mail", p.get("mail"));
		if(p.get("name")!=null)
			m.put("name", p.get("name"));
		u.changeInfo(p);
		return mv;
	}
	
	public void setU(UserDao u) {
		this.u = u;
	}
	
}
