package service;

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

	@Override
	public boolean upload(Item i) {
		// TODO �Զ����ɵķ������
		itemMapper.add(i);

		return true;
	}

	@Override
	public boolean down(Item i) {
		// TODO �Զ����ɵķ������

		return false;
	}

	@Override
	public void change(Map<String, Object> p) {
		itemMapper.Update(p);
		// TODO �Զ����ɵķ������

	}

}
