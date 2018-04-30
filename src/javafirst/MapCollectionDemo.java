package javafirst;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;

public class MapCollectionDemo {

	public static void main(String[] args) {
int mlt = 1;
	for(int i = 1; i<=5; i++) {
		mlt = mlt*i;
	}
	System.out.println(mlt);
	List<String> lst = new ArrayList<>();
lst.add("Java");
lst.add("Selenium");
lst.add("UFT");
int ml = 0;
String l = null;
for(String l1:lst) {
	int ll = l1.length();
	if(ml<ll) {
		ml=ll;
		l = l1;
	}
}
	System.out.println(l);
	
	String str = "1";
	String str1 = "";
	for(int i = 0; i<=5; i++) {
		str1 = str1+str+" ";
		System.out.println(str1);
	}
	String s1 = "Dhaval";
	StringBuffer b1 = new StringBuffer(String.valueOf(s1)).reverse();
	System.out.println(b1);
	}

}

	
