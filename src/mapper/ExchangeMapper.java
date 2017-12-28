package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import model.ExcDate;
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
	public List<Exchange> selectExc(Map<String ,String> m);
	
	/**
	 * 
	 * @param m仅能由应答方对订单状态做出修改，包含参数为status属性和订单id
	 * @return
	 */
	@Update("update tb_exchange set statu=#{statu} where id=#{id}")
	public int changeExc(Map<String,String> m);
	
	@Select("SELECT e.id , e.date , e.gid_a , e.gid_b , i1.name gname_a , i1.img img_a , i2.name gname_b , i2.img img_b ,e.info "
			+ "from tb_exchange e,tb_item i1,tb_item i2 "
			+ "where e.id=#{eid} and (i1.id=e.gid_a and i2.id=e.gid_b)")
	@ResultMap("ecxDate")
	public ExcDate selectExcAllDate(String eid);
	
	@Select("select count(*) from tb_exchange where gid_b=#{gid_b}")
	public Integer getRequestedCount(String gid_b);;
	
	@Select("SELECT e.id , e.date , e.gid_a , e.gid_b , i1.name gname_a , i1.img img_a , i2.name gname_b , i2.img img_b ,e.info "
			+ "from tb_exchange e,tb_item i1,tb_item i2 "
			+ "where e.#{uid_x}=#{uid} and e.gid_a=i1.id and e.gid_b=i2.id and e.statu=submit")
	@ResultMap("ecxDate")
	public List<ExcDate> selectMyExc(String uid_x,String uid);
}
