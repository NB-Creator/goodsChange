package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;

import po.Item;
import provider.ItemPro;

public interface ItemMapper {

	/**
	 * @param param key�����ݿ����,value�����ڲ�ѯ��ֵ
	 * 				��ѯ�۸�ʱ����һ������,priceLeftΪ�ͼ�,priceRightΪ�߼�
	 * ��ͨ����Ʒ���(id),����ʱ��(time),����(name),����(except),����(classfication),�۸�(price),uid��ѯ��Ʒ
	 */
	@SelectProvider(method="select",type=ItemPro.class)
	public List<Item> select(Map<String, String> param);
	
	@Insert("insert into tb_item values(#{id},#{time},#{name},#{detail},#{img},#{expect},#{classification},#{price},#{uid})")
	public int add(Item i);
	
	@Delete("delete from tb_item where id=#{id}")
	public int delete(Item i);
	
	/**
	 * @param param key�����ݿ����,value��Ҫ�޸ĵ�ֵ
	 * 				���봫��item������,�����봫��id
	 * �������޸���Ʒ����(name),��ϸ��Ϣ(detail),ͼƬ(img),����(except),����(classfication),�۸�(price)
	 */
	@SelectProvider(method="update",type=ItemPro.class)
	public int Update(Map<String, Object> param);
}
