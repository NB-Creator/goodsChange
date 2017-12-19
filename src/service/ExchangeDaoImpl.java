package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mapper.ExchangeMapper;
import model.ExcDate;
import po.Exchange;

@Service
@Transactional(readOnly=false,isolation=Isolation.READ_COMMITTED,rollbackFor=java.lang.Exception.class)
public class ExchangeDaoImpl implements ExchangeDao {

	@Autowired
	private ExchangeMapper excMapper;

	@Override
	public List<Exchange> selectExc(Map<String, String> m) {
		List<Exchange> excList = excMapper.selectExc(m);
		return excList;
	}

	@Override
	public String addExc(Exchange exc) {
		if (excMapper.addExc(exc) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public String deleteExc(String id) {
		if (excMapper.deleteExc(id) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public String changeExc(Map<String, String> m) {
		if (excMapper.changeExc(m) > 0)
			return "SUCCESS";
		else
			return "FALSE";
	}

	@Override
	public ExcDate getExcAllDate(String eid) {
		return excMapper.selectExcAllDate(eid);
	}
}
