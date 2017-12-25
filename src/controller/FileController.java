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
		File imageFile = null;// ���Դ洢�ϴ��ļ�

		String fileName = null;
		User user = (User) model.asMap().get("user");
		/*
		 * �����洢·���ļ��У���Ŀ¼Ϊ������ķ�������Ŀ¼+���·��(/file/img/�û��˻�)
		 */
		File savePath = new File(rq.getServletContext().getRealPath(
				"file/img/" + user.getUsername()));

		if (!savePath.exists()) {// ����·���������򴴽�
			savePath.mkdirs();
		}
		// �����ϴ���ͼƬ
		if (null != img) {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			fileName = sdf.format(d) + new Random().nextInt(1000) + ".jpg";// �õ�ǰʱ�����һ���������Ϊ�ļ���

			imageFile = new File(savePath.getPath(), fileName);// ����һ��savePath�ļ�·���£�����Ϊfilename���ļ�
			try {
				img.transferTo(imageFile);// ���ϴ���ͼ���ļ�д�뵽imageFile��
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ��������ļ������·������ǰ̨
		return "file/img/" + user.getUsername() + "/" + fileName;
	}
	
	/**
	 * 
	 * @param imgpathΪ��Ʒ��ͼƬ�ڷ�����Ŀ¼�µ����·��ƴ�ӵ��ַ�����ÿ��·���ַ���֮����*����
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
