package service;

import java.lang.reflect.Field;
import java.util.Map;

import mapper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import po.Item;

@Service
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;

	/*
	 * 上传商品，并检测商品各属性是否为空，并返回一个布尔值
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
	 * 商品下架
	 * @see service.ItemDao#down(po.Item)
	 */
	@Override
	public boolean down(Item i) {
		

		return false;
	}

	@Override
	public void change(Map<String, Object> p) {
		itemMapper.Update(p);
	}

}
