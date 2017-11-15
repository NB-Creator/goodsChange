package provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
public class ItemPro {
	

	public String select(Map<String, String> p) {
		return new SQL(){
			{
				SELECT("*");
				FROM("tb_item");
				if(p.get("id")!=null)
					WHERE("id=#{id}");
				if(p.get("time")!=null)
					WHERE("time=#{time}");
				if(p.get("name")!=null);
					WHERE("name=#{name}");
				if(p.get("classfication")!=null)
					WHERE("classfication=#{classfication}");
				
				if((p.get("priceLeft")!=null)&&(p.get("prcieRight")!=null))
					WHERE("price between #{priceLeft} and #{priceRight}");
				else 
					if(p.get("priceLeft")!=null)
						WHERE("price >= #{priceLeft}");
					else
						if(p.get("priceRight")!=null)
							WHERE("price <= #{priceRight}");
				
				if(p.get("uid")!=null)
					WHERE("uid=#{uid}");
				if(p.get("expect")!=null);
					WHERE("expect like #{expect}");
			}
		}.toString();
	}

	public String update(Map<String, Object> p) {
		return new SQL(){
			{
				UPDATE("tb_item");
				if(p.get("name")!=null);
					SET("name=#{name}");
				if(p.get("classification")!=null)
					SET("classification=#{classification}");
				if(p.get("price")!=null)
					SET("price=#{price}");
				if(p.get("expect")!=null);
					SET("expect=#{expect}");
				if(p.get("detail")!=null)
					SET("detail=#{detail}");
				if(p.get("img")!=null)
					SET("img=#{img}");
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
