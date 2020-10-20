package eg3;
import eg2.Hello;

public class HelloAgainMain extends Hello {

	public static void main(String[] args) {
		Hello h = new Hello();
		h.helloPublic();
		
		HelloAgainMain m = new HelloAgainMain();
		m.helloProtected();
	}

}
