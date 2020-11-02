package eg1;

public class Implementor implements MyInterface {

    @Override
    public void method() {
        System.out.println("Hello from interface x = " + x);
    }
}
