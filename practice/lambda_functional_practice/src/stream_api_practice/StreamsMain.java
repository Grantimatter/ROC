package stream_api_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMain {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(12, 34, 176, 23, 43, 63, 98, 2, 51, 42);
        System.out.println("list1 = " + list1);

        List<Integer> list2 = new ArrayList<>();

        // Copy all odd integers in in different List
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) % 2 != 0){
                list2.add(list1.get(i));
            }
        }
        System.out.println("list2 = " + list2);

        List<Integer> listStream = list1.stream().filter(x -> (x % 2) != 0).collect(Collectors.toList());
        List<Integer> lStreamMod = list1.stream().filter(x -> (x % 2) != 0).map(x -> x + 124).sorted().collect(Collectors.toList());

        System.out.println("listStream = " + listStream);
        System.out.println("lStreamMod = " + lStreamMod);
    }
}
