package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ExchangeMapper;
import po.Exchange;

@Service
public class ExchangeDaoImpl implements ExchangeDao {

	@Autowired
	private ExchangeMapper excMapper;

	@Override
	public List<Exchange> selectExc(Map<String, String> m) {
		// TODO 自动生成的方法存根
		List<Exchange> excList = excMapper.selectExc(m);
		return excList;
	}

	@Override
	public String addExc(Exchange exc) {
		// TODO 自动生成的方法存根
		if (excMapper.addExc(exc) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public String deleteExc(String id) {
		// TODO 自动生成的方法存根
		if (excMapper.deleteExc(id) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public String changeExc(Map<String, String> m) {
		// TODO 自动生成的方法存根
		if (excMapper.changeExc(m) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

}
