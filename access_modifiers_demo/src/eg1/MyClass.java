package eg1;

public class MyClass {
	
	public static void myStatic() {
		System.out.println("Hello static from myNonStatic");
	}
	
	public void myNonStatic() {
		System.out.println("Hello static from myNonStatic");
	}
	
	private class InnerPrivate {

	}

	protected class InnerProtected {

	}

	public class InnerPublic {
		
		public void helloInnerPublic() {
			System.out.println("Hello from helloInnerPublic()");
		}
		
		public class InnerInnerPublic {

		}
	}

	public static class InnerStaticPublic {
		public static void helloInnerPublicStatic() {
			System.out.println("hello from helloInnerPublicStatic");
		}
		public void helloInnerStaticNonStatic() {
			System.out.println("Hello from helloinnerStaticNonStatic");
		}
	}
}

class A {

}

class B {

}

class C {

}

//public class M{
//	
//}
