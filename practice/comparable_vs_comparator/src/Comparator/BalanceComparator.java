package Comparator;

import java.util.Comparator;

public class BalanceComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return (int)(o1.getBalance() - o2.getBalance());
    }
}
