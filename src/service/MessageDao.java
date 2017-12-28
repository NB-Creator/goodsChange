package service;

import java.util.List;
import java.util.Map;

import po.Message;

public interface MessageDao {

	public List<Message> getMessage(Map<String, String> m);
	
	public int changeMessage(Message m);
}
