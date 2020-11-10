package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(32, "Alfred"));
        userList.add(new User(16, "Jimmy"));
        userList.add(new User(23, "Grant"));
        userList.add(new User(48, "Johnathon"));
        userList.add(new User(12, "Elijah"));

        System.out.println("Users before Sorting...");
        printList(userList);

        Collections.sort(userList);

        System.out.println("\nUsers after sorting");
        printList(userList);
    }

    public static void printList(List<User> list){
        for (User u:list){
            System.out.println(String.format("Name: %s | Age: %d", u.getName(), u.getAge()));
        }
    }
}
