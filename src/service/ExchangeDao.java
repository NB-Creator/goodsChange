package service;

import java.util.List;
import java.util.Map;

import model.ExcDate;
import po.Exchange;

public interface ExchangeDao {
	/**
	 * 
	 * @param key为查寻订单条件(按日期查询时需要键入year和month两个键值)
	 * @return 订单列表
	 */
	public List<Exchange> selectExc(Map<String,String> m);
	
	public String addExc(Exchange exc);
	
	/**
	 * 
	 * @param id为删除的订单id
	 * @return
	 */
	public String deleteExc(String id);
	
	/**
	 * 
	 * @param key为订单id和交易状态status
	 * @return
	 */
	public String changeExc(Map<String,String> m);
	
	public ExcDate getExcAllDate(String eid);
	
	/**
	 * @param uid_a 如果查询自己提交的交换单信息就设置为uid,uid_b设置为%
	 * @param uid_b 如果查询自己是被请求方的交换单信息就设置为uid,uid_a设置为%
	 * @return
	 */
	public List<ExcDate> getMyExc(String uid_a,String uid_b);
}
