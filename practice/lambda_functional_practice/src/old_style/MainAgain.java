package old_style;

public class MainAgain {
    public static void main(String[] args) {
        Sort s1 = new Sort(){
            @Override
            public void sortAnything() {
                System.out.println("Sort something here");
            }
        };

        Sort s2 = new Sort(){
            @Override
            public void sortAnything() {
                System.out.println("Sort something else here");
            }
        };

        s1.sortAnything();
        s2.sortAnything();
    }
}
