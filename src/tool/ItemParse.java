package tool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.Item;

public class ItemParse {
	
	/**
	 * 
	 * @param itemList
	 * @return 将imgPath转换成List返回
	 */
	static public List<Item> parseItemImg(List<Item> itemList) {
		List<Item> IL = itemList;
		Iterator<Item> i = IL.iterator();
		while (i.hasNext()) {
			Item item = i.next();
			String img = item.getImg();
			String imgs[] = img.split("\\*");
			List<String> ls = new ArrayList<String>();
			int l = imgs.length;
			for (int j = 0; j < l; j++) {
				ls.add(imgs[j]);
			}
			item.setImgpath(ls);
		}
		return IL;
	}
}
