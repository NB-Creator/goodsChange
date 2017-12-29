package provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class MessageProvider {

	public String select(Map<String, String> p){
		return new SQL(){
			{
				SELECT("*");
				FROM("message");
				Object obj=null;
				if((obj=p.get("usernameA"))!=null)
					WHERE((String)obj);
				if((obj=p.get("usernameB"))!=null)
					WHERE((String)obj);
				if((obj=p.get("excId"))!=null)
					WHERE((String)obj);
				if((obj=p.get("status"))!=null)
					WHERE((String)obj);
			}
		}.toString();
	}
}
