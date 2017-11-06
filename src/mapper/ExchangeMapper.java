package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import po.Exchange;
import provider.ExchangePro;

public interface ExchangeMapper {
	
	@Insert("insert into tb_exchange values(#{id},#{uid_a},#{uid_b},#{gid_a},#{gid_b},#{date},#{info},#{statu})")
	public int addExc(Exchange exc);
	
	/**
	 * 
	 * @param id要删除的订单id
	 * @return 
	 */
	@Delete("delete from tb_exchange where id=#{id}")
	public int deleteExc(String id);
	
	/**
	 * 
	 * @param key为查询条件(按日期查询时需要键入year和month两个键值)
	 * @return
	 */
	@SelectProvider(method="select",type=ExchangePro.class)
	public List<Exchange> selectExc(Map<String ,Object> m);
	
	/**
	 * 
	 * @param m仅能由应答方对订单状态做出修改，包含参数为status属性和订单id
	 * @return
	 */
	@Update("update tb_exchange set statu=#{statu} where id=#{id}")
	public int changeExc(Map<String,String> m);
}
