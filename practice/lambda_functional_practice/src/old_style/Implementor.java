package old_style;

public class Implementor implements Sort {
    @Override
    public void sortAnything() {
        System.out.println("Sort something, but not multiple types");
    }
}
