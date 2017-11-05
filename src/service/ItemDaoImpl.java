package service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ItemMapper;
import po.Item;

@Service
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;

	/*
	 * �ϴ���Ʒ���������Ʒ�������Ƿ�Ϊ�գ�������һ������ֵ
	 * @see service.ItemDao#upload(po.Item)
	 */
	@Override
	public boolean upload(Item i) {
		
		boolean flag = true;
	    for(Field f :i.getClass().getDeclaredFields()){
	        f.setAccessible(true);
	       System.out.println(f.getName());
	        try {
				if(f.get(i) == null){
				    flag = false;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	    }
	    if(flag){
	    	itemMapper.add(i);
			
		}
	    return flag;
	}

	/*
	 * ��Ʒ�¼�
	 * @see service.ItemDao#down(po.Item)
	 */
	@Override
	public boolean down(Item i) {
		Map<String,String> p=new HashMap<>();
		if(i.getUid()==null)
			return false;
		p.put("id", String.valueOf(i.getId()));
		if(itemMapper.select(p).isEmpty())
			return false;
		itemMapper.delete(i);

		return true;
	}

	@Override
	public void change(Map<String, Object> p) {
		itemMapper.Update(p);
	}

}
