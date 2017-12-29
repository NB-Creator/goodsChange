package service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mapper.ExchangeMapper;
import mapper.MessageMapper;
import model.ExcDate;
import po.Exchange;
import po.Message;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
public class ExchangeDaoImpl implements ExchangeDao {

	@Autowired
	private ExchangeMapper excMapper;
	@Autowired
	private MessageMapper msgMapper;

	@Override
	public List<Exchange> selectExc(Map<String, String> m) {
		List<Exchange> excList = excMapper.selectExc(m);
		return excList;
	}

	@Override
	public String addExc(Exchange exc) {
		if (excMapper.addExc(exc) > 0){
			Message m=new Message(exc.getUid_a(), exc.getUid_b(), exc.getId(), "来,我给你看个宝贝!", 0);
			if(msgMapper.insert(m) > 0)
				return "SUCCESS";
		}
		return "FALSE";
	}

	@Override
	public String deleteExc(String id) {
		if (excMapper.deleteExc(id) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public String changeExc(Map<String, String> m) {
		if (excMapper.changeExc(m) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public ExcDate getExcAllDate(String eid) {
		ExcDate item=excMapper.selectExcAllDate(eid);
		String img_a = item.getImg_a();
		String imgs[] = img_a.split("\\*");
		item.setImg_a(imgs[0]);
		String img_b = item.getImg_b();
		String imgs_[] = img_b.split("\\*");
		item.setImg_b(imgs_[0]);
		return item;
		
	}

	@Override
	public List<ExcDate> getMyExc(String uid_a, String uid_b) {
		// TODO 自动生成的方法存根
		List<ExcDate> excList = excMapper.selectMyExc(uid_a,uid_b);
		Iterator<ExcDate> i=excList.iterator();
		while(i.hasNext()) {
			ExcDate item=i.next();
			String img_a = item.getImg_a();
			String imgs[] = img_a.split("\\*");
			item.setImg_a(imgs[0]);
			String img_b = item.getImg_b();
			String imgs_[] = img_b.split("\\*");
			item.setImg_b(imgs_[0]);
		}
		
		return excList;
	}

	public void setMsgMapper(MessageMapper msgMapper) {
		this.msgMapper = msgMapper;
	}

	public void setExcMapper(ExchangeMapper excMapper) {
		this.excMapper = excMapper;
	}
}
