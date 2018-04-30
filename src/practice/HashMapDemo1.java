package practice;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {

	Map<Integer,Integer> pl = new HashMap<>();
	for(int x=0; x<5; x++) {
		int y= x+1;
		y = x+y;
		int n= x+2;
		n = x+n;		
	
	pl.put(y, n);
	}
	
	Set<Integer>keys = pl.keySet();
	for(int i:keys ) {
		System.out.println(i+" = "+pl.get(i).intValue());
	}
	
	Map<String,Integer>record = new HashMap<>();
	record.put("Dhaval", 38);
	record.put("Dhara", 32);
	record.put("Niket", 11);
	
	Set<String>name = record.keySet();
	for(String s:name) {
		System.out.println(s+" , "+record.get(s).intValue());
	}
	
	int a [] = new int[5];
	a[0] = 10;
	
	
	
	
	}

}
