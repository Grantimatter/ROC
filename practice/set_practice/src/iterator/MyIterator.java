package iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MyIterator {
    public static void main(String[] args) {
        // Remove all Key-Value pairs whose key is a multiple of 10 or whose value is null

        Map<Integer, String> hm = new HashMap<>();
        hm.put(100, "Hello");
        hm.put(100, "Updated");
        hm.put(101, "alpha");
        hm.put(992, "nation");
        hm.put(231, "applesauce");
        hm.put(442, "unique1");
        hm.put(200, "unique2");
        hm.put(300, "unique3");
        hm.put(657, null);
        hm.put(23, null);
        hm.put(14, null);
        hm.put(657, null);
        hm.put(86, null);
        hm.put(980, null);
        hm.put(54, null);
        System.out.println("Before Cleaning:\nhm : "+hm);

//        for (Map.Entry<Integer, String> e:hm.entrySet()){
//            if(e.getKey()%10==0 || e.getValue()==null) {
//                hm.remove(e.getKey());
//            }
//        }

        // Set up the iterator
        Iterator<Entry<Integer, String>> i=hm.entrySet().iterator();
        // Continue looping if there is a next entry
        while(((java.util.Iterator) i).hasNext()){
            // Select the next entry in the set
            Entry<Integer, String> e=i.next();

            // Remove the entry if it is divisible by 10 or has a null value
            if(e.getKey()%10==0 || e.getValue() == null){
                i.remove();
            }
        }

        System.out.println("After Cleaning:\nhm : "+hm);
    }

    /*
    *   Enumerator      -> Read from top to bottom
    *   Iterator        -> Read and remove from top to bottom
    *   ListIterator    -> add, read, remove, and is bidirectional but it is applicable only on List interface
     */


}
