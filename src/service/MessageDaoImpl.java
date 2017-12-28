package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.MessageMapper;
import po.Message;

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

}
