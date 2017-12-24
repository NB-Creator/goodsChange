package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import po.Comment;
import service.CommentDao;

@Controller
public class CommentController {

	@Autowired
	private CommentDao commentd;
	
	/**
	 * 
	 * @param 商品评论，前台提供g_id,info,u_id,后台获取时间
	 */
	@RequestMapping("/comment")
	public @ResponseBody String comment(Comment comment) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		comment.setDate(sdf.format(date));
		if (commentd.addComment(comment) != 0)
			return "success";
		return "false";
	}

	/**
	 * 
	 * @param 获取商品评论列表
	 * @return 该商品的评论列表
	 */
	@RequestMapping(value="/getComment",produces="text/plain;charset=UTF-8")
	public @ResponseBody String getComment(@RequestParam("itemid") String itemid) {
		List<Comment> commentList = commentd.findComment(itemid);
		return JSON.toJSONString(commentList);
	}

	public void setCommentd(CommentDao commentd) {
		this.commentd = commentd;
	}

}
