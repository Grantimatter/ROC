package wrappers_and_string_api;

import java.util.Scanner;

public class WrapperMain {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
        double d = scanner.nextDouble();
        String s = "";
        scanner.nextLine();
        s = scanner.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

	}
}
