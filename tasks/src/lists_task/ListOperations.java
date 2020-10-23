package lists_task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListOperations {
	
	public static List<String> createStringList(String[] str){
		try {
			List<String> list = new ArrayList();
			for(String s:str){
				list.add(s);
			}
			return list;
		} catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}

	// Generic List creation (not working)
	/*
	public static <T> List<T> createGenericList(Collection<T> c) throws Exception {
		try {
			List<T> list = new ArrayList();
			list.addAll(c);
			//List<Integer> list = new ArrayList();
			
			return list;
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
	*/
}
