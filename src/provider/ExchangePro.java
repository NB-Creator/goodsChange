package provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ExchangePro {

	public String select(Map<String, Object> m) {
		return new SQL() {

			{
				SELECT("*");
				FROM("tb_exchange");
				if(m.get("id")!=null)
					WHERE("id=#{id}");
				if(m.get("uid_a")!=null)
					WHERE("uid_a=#{uid_a}");
				if(m.get("uid_b")!=null)
					WHERE("uid_b=#{uid_b}");
				if(m.get("statu")!=null)
					WHERE("statu=#{statu}");
				if(m.get("year")!=null&&m.get("month")!=null)
					WHERE("year(date)=#{year} and month(date)=#{month}");
			}

		}.toString();
	}
}
