package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mapper.CollectMapper;
import mapper.CommentMapper;
import mapper.ExchangeMapper;
import mapper.ItemMapper;
import model.ItemAllData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import po.Item;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ExchangeMapper eMapper;
	@Autowired
	private CollectMapper colMapper;
	@Autowired
	private CommentMapper comMapper;

	/*
	 * 上传商品，并检测商品各属性是否为空，并返回一个布尔值
	 * 
	 * @see service.ItemDao#upload(po.Item)
	 */
	@Override
	public boolean upload(Item i) {

		/*
		 * boolean flag = true; for (Field f : i.getClass().getDeclaredFields())
		 * { f.setAccessible(true); System.out.println(f.getName()); try { if
		 * (f.get(i) == null) { flag = false; } } catch
		 * (IllegalArgumentException e) { e.printStackTrace(); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); } } if (flag) {
		 */
		if (itemMapper.add(i) > 0) {
			System.out.println("FABU");
			return true;
		} else {
			return false;
		}

	}

	/*
	 * 商品下架
	 * 
	 * @see service.ItemDao#down(po.Item)
	 */
	@Override
	public boolean down(Item i) {
		Map<String, String> p = new HashMap<>();
		if (i.getUid() == null)
			return false;
		p.put("id", String.valueOf(i.getId()));
		if (itemMapper.select(p).isEmpty())
			return false;
		itemMapper.delete(i);

		return true;
	}

	/**
	 * 修改商品信息
	 */
	@Override
	public void change(Map<String, String> p) {
		itemMapper.Update(p);
	}

	public List<Item> find(Map<String, String> p) {
		List<Item> IL = itemMapper.select(p);
		Iterator<Item> i = IL.iterator();
		while (i.hasNext()) {
			Item item = i.next();
			String img = item.getImg();
			String imgs[] = img.split("\\*");
			List<String> ls = new ArrayList<String>();
			int l = imgs.length;
			for (int j = 0; j < l; j++) {
				ls.add(imgs[j]);
			}
			item.setImgpath(ls);
		}
		return IL;
	}

	@Override
	public boolean deleteImg(String imgPath,int ItemId) {
		Map<String,String> param = new HashMap<>();
		param.put("id",String.valueOf(ItemId));
		Item item = find(param).get(0);
		List<String> imgs=item.getImgpath();
		StringBuilder img=new StringBuilder();
		
		Iterator<String> i=imgs.iterator();
		while(i.hasNext()){
			String path=i.next();
			if(path!=imgPath)
				img.append(path+"*");
		}
		img.deleteCharAt(img.length()-1);
		
		param.clear();
		param.put("id", String.valueOf(ItemId));
		param.put("img", img.toString());
		
		if(itemMapper.Update(param)==0)
			return false;
		return true;
	}

	@Override
	public List<Item> selectFreeItem(Map<String, String> m) {
		List<Item> IL = itemMapper.selectFreeItem(m);
		Iterator<Item> i = IL.iterator();
		while (i.hasNext()) {
			Item item = i.next();
			String img = item.getImg();
			String imgs[] = img.split("\\*");
			List<String> ls = new ArrayList<String>();
			int l = imgs.length;
			for (int j = 0; j < l; j++) {
				ls.add(imgs[j]);
			}
			item.setImgpath(ls);
		}
		return IL;
	}

	@Override
	public ItemAllData getAllDate(String id) {
		ItemAllData itemDate=new ItemAllData();
		Map<String, String> param=new HashMap<>();
		param.put("id", id);
		itemDate.setItem(itemMapper.select(param).get(0));
		itemDate.setCollect(colMapper.getCollectedCount(id));
		itemDate.setRq(eMapper.getRequestedCount(id));
		itemDate.setComment(comMapper.getCount(id));
		itemDate.setCommentList(comMapper.find(id));
		return itemDate;
	}
	
	@Override
	public List<Item> getPopular() {
		return itemMapper.selectPoplarItems();
	}

	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	public void seteMapper(ExchangeMapper eMapper) {
		this.eMapper = eMapper;
	}

	public void setColMapper(CollectMapper colMapper) {
		this.colMapper = colMapper;
	}

	public void setComMapper(CommentMapper comMapper) {
		this.comMapper = comMapper;
	}


}
