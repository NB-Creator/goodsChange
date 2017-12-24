package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import po.User;
import service.ItemDao;

@Controller
@SessionAttributes("user")
@RequestMapping("/file")
public class FileController {

	@Autowired
	private ItemDao i;
	
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public @ResponseBody String uploadImg(HttpServletRequest rq,
			@RequestParam("img") MultipartFile img, Model model) {
		File imageFile = null;// 用以存储上传文件

		String fileName = null;
		User user = (User) model.asMap().get("user");
		/*
		 * 创建存储路径文件夹，该目录为：部署的服务器根目录+相对路径(/file/img/用户账户)
		 */
		File savePath = new File(rq.getServletContext().getRealPath(
				"file/img/" + user.getUsername()));

		if (!savePath.exists()) {// 若该路径不存在则创建
			savePath.mkdirs();
		}
		// 保存上传的图片
		if (null != img) {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			fileName = sdf.format(d) + new Random().nextInt(1000) + ".jpg";// 用当前时间戳和一个随机数作为文件名

			imageFile = new File(savePath.getPath(), fileName);// 创建一个savePath文件路径下，名字为filename的文件
			try {
				img.transferTo(imageFile);// 将上传的图像文件写入到imageFile中
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 将保存的文件的相对路径返回前台
		return "file/img/" + user.getUsername() + "/" + fileName;
	}
	
	/**
	 * 
	 * @param imgpath为商品的图片在服务器目录下的相对路径拼接的字符串，每个路径字符串之间由*隔开
	 */
	@RequestMapping("/deleteImg")
	public @ResponseBody void deleteImg(@RequestParam("img")String img,int ItemId,HttpServletRequest rq){
		File imgFile = new File(rq.getServletContext().getRealPath("file/img/"+img));
		imgFile.delete();
		i.deleteImg(img, ItemId);
	}

	public void setI(ItemDao i) {
		this.i = i;
	}
	
}
