package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mapper.CollectMapper;
import po.Collect;
import po.Item;
import tool.ItemParse;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
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
		Map<String, String> map=new HashMap<>();
		map.put("uid", uid);
		return cm.select(map);
	}

	public void setCm(CollectMapper cm) {
		this.cm = cm;
	}

	@Override
	public List<Collect> select(String uid, String gid) {
		Map<String, String> map=new HashMap<>();
		map.put("uid", uid);
		map.put("gid",gid);
		return cm.select(map);
	}

	@Override
	public List<Item> getMyCollectItem(String uid) {
		return ItemParse.parseItemImg(cm.getMyCollect(uid));
	}
	

}