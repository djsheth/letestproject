package javafirst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortingListCollection {

	public static void main(String[] args) {

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(56);
		ls.add(67);
		ls.add(78);
		ls.add(32);
		ls.add(21);
		
		Collections.sort(ls);
		Collections.reverse(ls);
		
		for(Integer s : ls) {
			System.out.println(s);
		}
	}

}
