package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mapper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Item;

@Service
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;

	/*
	 * �ϴ���Ʒ���������Ʒ�������Ƿ�Ϊ�գ�������һ������ֵ
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
	 * ��Ʒ�¼�
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
	 * �޸���Ʒ��Ϣ
	 */
	@Override
	public void change(Map<String, Object> p) {
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

}
