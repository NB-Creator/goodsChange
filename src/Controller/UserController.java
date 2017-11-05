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
			//����ѯ����user��Ϣ���沢������ҳ��
			mv.addObject("user", user);
			//���õ�¼�ɹ�·��
			mv.setViewName("main.jsp");
		}else
			mv.setViewName("loginFalse.jsp");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView resgiter(User user,ModelAndView mv){
		String msg=u.register(user);
		if(!msg.equals("SUCCESS")){
			//ע�᲻�ɹ�
			mv.setViewName("registFalse.jsp");
			//������Ϣ
			mv.addObject("msg", msg);
		}
		else{
			//ע��ɹ�
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
