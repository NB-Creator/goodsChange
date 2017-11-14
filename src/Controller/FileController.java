package Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import po.User;

@Controller
@SessionAttributes("user")
public class FileController {

	@RequestMapping(value="/uploadImg",method = RequestMethod.POST)
	public @ResponseBody String uploadImg(HttpServletRequest rq, 
			@RequestParam("img")MultipartFile img,Model model)
	{
		File imageFile = null;
		String fileName = null;
		User user=(User) model.asMap().get("user");
		/*
		 * 创建存储路径文件夹
		 */
		File savePath = new File(rq.getServletContext().getRealPath("file/img/"+user.getUsername()));
		if (!savePath.exists()) {
			System.out.println("该路径不存在");
			savePath.mkdirs();
		}
		if (null != img) {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			fileName = sdf.format(d)+new Random().nextInt(1000)+".jpg";//用时间戳和随机数作为文件名
			imageFile = new File(savePath.getPath(),
					fileName);
			try {
				img.transferTo(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "file/img/"+user.getUsername()+"/"+fileName;
	}
}
