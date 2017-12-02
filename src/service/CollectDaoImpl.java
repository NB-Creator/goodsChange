package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.CollectMapper;
import po.Collect;

public class CollectDaoImpl implements CollectDao {

	@Autowired
	private CollectMapper cm;
	
	@Override
	public int addCollect(Collect c) {
		return cm.insert(c);
	}

	@Override
	public int deleteCollect(int uid) {
		return cm.delete(uid);
	}

	@Override
	public List<Collect> findCollect(int uid) {
		return cm.find(uid);
	}

	public void setCm(CollectMapper cm) {
		this.cm = cm;
	}

}