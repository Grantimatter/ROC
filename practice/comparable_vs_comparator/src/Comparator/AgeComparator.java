package Comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        if(u1.getAge() < u2.getAge()) return -1;
        if(u1.getAge() > u2.getAge()) return 1;
        else return 0;
    }

}
