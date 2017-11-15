package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import po.Item;
import po.User;
import service.ItemDao;

@Controller
@SessionAttributes("user")
public class ItemController {

	@Autowired
	private ItemDao i;
	
	@RequestMapping("/addItemPage")
	public String addItemPage(){
		return "addItem";
	}
	
	
	@RequestMapping("/uploadItem")
	public @ResponseBody String upload(Model model,Item item){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = new Date();
		item.setId(sdf.format(d)+new Random().nextInt(1000));
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		item.setTime(sdf.format(d));
		item.setUid(((User)model.asMap().get("user")).getUsername());
		boolean flag = i.upload(item);
		if(flag==false)
			return "false";
		else
			return "success";
	}
	
	@RequestMapping("/getImgpath")
	public @ResponseBody String getImgpath(@RequestParam("path") String aa){
	   System.out.println("afdfa");
	   String aaa[]=aa.split("\\*");
	   
	   System.out.println("length:"+aaa.length);
		
		for(int i=0;i<aaa.length;i++){
			System.out.println("aaaa"+i+" "+aaa[i]);
		}
		return "success";
		
	} 
	
	public ModelAndView down(ModelAndView mv,Item item){
		boolean flag=i.down(item);
		if(flag==false)
			mv.setViewName("downSuccess.jsp");
		else
			mv.setViewName("downFalse.jsp");
		return mv;
	}
	
	public ModelAndView change(ModelAndView mv,Item item){
		Map<String,Object> p=new HashMap<>();
		
		if(item.getName()!=null);
			p.put("name", item.getName());
		if(item.getclassification()!=null)
			p.put("classification", item.getclassification());
		if(item.getPrice()!=null)
			p.put("price", item.getPrice());
		if(item.getexpect()!=null);
		p.put("execpt", item.getexpect());
		if(item.getDetail()!=null)
			p.put("detail", item.getDetail());
		if(item.getImg()!=null)
			p.put("img", item.getImg());
		
		i.change(p);
		mv.setViewName("changeSuccess.jsp");
		return mv;
	}
	
	public @ResponseBody List<Item> find(HashMap<String, String> p){
		return i.find(p);
	}
}