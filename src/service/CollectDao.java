package service;

import java.util.List;

import po.Collect;

public interface CollectDao {

	public int addCollect(Collect c);
	
	public int deleteCollect(int uid);
	
	public List<Collect> findCollect(int uid);
}
