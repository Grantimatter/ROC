package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(32, "Alfred"));
        userList.add(new User(16, "Jimmy"));
        userList.add(new User(23, "Grant"));
        userList.add(new User(48, "Johnathon"));
        userList.add(new User(12, "Elijah"));

        System.out.println("Users before sorting");
        printList(userList);

        // Sort by Name
        NameComparator nameComparator = new NameComparator();
        Collections.sort(userList, nameComparator);
        System.out.println("\nUsers sorted by Name");
        printList(userList);

        // Sort by Age
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(userList, ageComparator);
        System.out.println("\nUsers sorted by Age");
        printList(userList);
    }

    public static void printList(List<User> list){
        for (User u:list){
            System.out.println(u.toString());
        }
    }
}
