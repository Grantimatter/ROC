package key_value_pairs;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {

        // HashMap map
        Map<Integer, String> hm = new HashMap<>();
        hm.put(100, "Hello");
        hm.put(100, "Updated");
        hm.put(101, "New String");
        hm.put(992, "value");
        hm.put(null, null);
        System.out.println("hm : "+hm);

        // Hashtable Map
        Map<Integer, String> ht = new Hashtable<>();
        ht.put(100, "Hello");
        ht.put(100, "Updated");
        ht.put(101, "Testing 123");
        ht.put(992, "java");
        System.out.println("ht : "+ht);

        System.out.println("ht.get(992) : "+ht.get(992));
        System.out.println("ht.get(993) : "+ht.get(993));

        System.out.println("ht.containsKey(100) : "+ht.containsKey(100));
        System.out.println("ht.containsValue(\"Updated\") : "+ht.containsValue("Updated"));

        ht.remove(100);
        System.out.println("ht : "+ht);

        System.out.println("Keys : "+ht.keySet());
        System.out.println("Values : "+ht.values());

        System.out.println("\nIterating using entrySet()");
        for(Map.Entry<Integer, String> e:ht.entrySet()){
            System.out.println("[Key : " + e.getKey() + " | Value : "+e.getValue()+"]");
        }
    }
}
