package eg1;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPracticeMain {
	public static void main(String[] args) {
		// HashSet
		Set<String> hs = new HashSet<>();
		hs.add("Hello");
		hs.add("");
		hs.add(null);
		hs.add("hibernate");
		hs.add("c++");
		System.out.println("hs : "+hs);
		
		// LinkedHashSet
		Set<String> lhs = new LinkedHashSet<>();
		lhs.add("Hello");
		lhs.add("");
		lhs.add(null);
		lhs.add("hibernate");
		lhs.add("c++");
		System.out.println("lhs : "+lhs);
		
		Set<String> ts = new TreeSet<>(); // A-Z
		ts.add("Hello");
		ts.add("");
		ts.add("hibernate");
		ts.add("c++");
		System.out.println("ts : "+ts);

		ts.remove("hibernate");
		System.out.println(ts);
	}

}
