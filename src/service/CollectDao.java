package service;

import java.util.List;

import po.Collect;

public interface CollectDao {

	public int addCollect(Collect c);
	
	public int deleteCollect(String uid, String gid);
	
	public List<Collect> findCollect(String uid);
	
	public List<Collect> select(String uid,String gid);
}
