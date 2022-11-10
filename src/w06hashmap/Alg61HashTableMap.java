package w06hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 
 * @author bahadr
 *
 */
public class Alg61HashTableMap {

	public static void main(String args[]) {

		Map<String, String> ht = new HashMap<String, String>();
		ht = new Hashtable<String, String>();
		ht.put("ahmet", "312 1233212");
		ht.put("mehmet", "212 1233212");
		ht.put("ali", "412 1233212");
		ht.put("veli", "512 1233212");
		System.out.println(ht.get("ali"));
	}
}
