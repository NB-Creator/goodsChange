package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.MessageMapper;
import po.Message;

@Service
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private MessageMapper msgMapper;
	
	@Override
	public List<Message> getMessage(Map<String, String> m) {
		return msgMapper.select(m);
	}

	@Override
	public int changeMessage(Message m) {
		return msgMapper.update(m);
	}

	public void setMsgMapper(MessageMapper msgMapper) {
		this.msgMapper = msgMapper;
	}

	@Override
	public int deletMessage(String excId) {
		// TODO 自动生成的方法存根
		return msgMapper.delete(excId);
	}

	@Override
	public int unread(String uid) {
		// TODO 自动生成的方法存根
		return msgMapper.unread(uid);
	}

}
