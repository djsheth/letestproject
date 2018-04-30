package javafirst;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapHashMapDemo {

	public static void main(String[] args) {
Map<String,Integer> map = new HashMap<>();
map.put("Dhaval", 37);
map.put("Dhara", 32);
map.put("Niket", 11);

Set<String> keys = map.keySet();

for(String s:keys) {
	System.out.println(s+" "+map.get(s));
}
Set<Map.Entry<String, Integer>> values = map.entrySet();
for(Map.Entry<String, Integer> d:values) {
	System.out.println(d.getKey()+" : "+d.getValue());
}

	}

}
