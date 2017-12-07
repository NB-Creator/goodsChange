package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.CollectMapper;
import po.Collect;

@Service
public class CollectDaoImpl implements CollectDao {

	@Autowired
	private CollectMapper cm;
	
	@Override
	public int addCollect(Collect c) {
		return cm.insert(c);
	}

	@Override
	public int deleteCollect(String uid, String gid) {
		return cm.delete(uid,gid);
	}

	@Override
	public List<Collect> findCollect(String uid) {
		return cm.find(uid);
	}

	public void setCm(CollectMapper cm) {
		this.cm = cm;
	}

	@Override
	public List<Collect> select(String uid, String gid) {
		
		return cm.select(uid, gid);
	}
	

}