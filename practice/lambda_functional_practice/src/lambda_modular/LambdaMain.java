package lambda_modular;

public class LambdaMain {
    public static void main(String[] args) {
        SortFunctional s1 = () -> System.out.println("Hello Lambda");
        SortFunctional s2 = () -> System.out.println("Hello Lambda Again");
        HelloFunctional h1 = (n) -> System.out.println("Hello " + n + "!");

        AdditionFunctional a1 = (x, y, z) -> { return x + y + z; };

        s1.sortAnything();
        s2.sortAnything();
        h1.sayHello("Grant");
        System.out.println("X+Y+Z = " + a1.add(24, 62, 89));
    }
}
