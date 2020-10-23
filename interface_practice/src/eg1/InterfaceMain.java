package eg1;

public class InterfaceMain {
    public static void main(String[] args) {

        Implementor implementor = new Implementor();
        implementor.method();
        String s = "";

        System.out.println("\nAccess inner interface methods");
    }
}
