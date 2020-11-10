package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(32, "Alfred", 100.23d));
        userList.add(new User(16, "Jimmy", 527.12d));
        userList.add(new User(23, "Grant", 188.90d));
        userList.add(new User(48, "Johnathon", 2287.20d));
        userList.add(new User(12, "Elijah", 80.64d));

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

        // Sort by Balance
        BalanceComparator balanceComparator = new BalanceComparator();
        Collections.sort(userList, balanceComparator);
        System.out.println("\nUsers sorted by Balance");
        printList(userList);
    }

    public static void printList(List<User> list){
        for (User u:list){
            System.out.println(u.toString());
        }
    }
}
