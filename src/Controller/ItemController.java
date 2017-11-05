package Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.portlet.ModelAndView;

import po.Item;
import service.ItemDao;

public class ItemController {

	@Autowired
	private ItemDao i;
	
	public ModelAndView upload(ModelAndView mv,Item item){
		boolean flag = i.upload(item);
		if(flag==false)
			mv.setViewName("uploadSuccess.jsp");
		else
			mv.setViewName("uploadFalse.jsp");
		return mv;
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
}