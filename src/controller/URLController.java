package controller;

import org.springframework.web.bind.annotation.RequestMapping;

//Ìø×ª¿ØÖÆÆ÷
public class URLController {

	@RequestMapping("/selectPage")
	public String selectPage() {
		return "itemPage/selectPage";
	}
	
	@RequestMapping("/otherUser")
	public String otherUser() {
		return "itemPage/otherUser";
	}
	
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


	@RequestMapping("/excPage")
	public String exchangePage() {
		return "itemPage/excPage";
	}
	
	@RequestMapping("/excSuc")
	public String returnExcSuc() {
		return "itemPage/excSuc";
	}
	
	@RequestMapping("/itemAdmin")
	public String returnItemAdmin() {
		return "itemPage/itemAdmin";
	}
}
