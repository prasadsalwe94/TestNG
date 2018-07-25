package annotationTest;
import org.testng.annotations.Test;
public class ClassB {
	@Test
	public void m1OfB() {
		System.out.println("Insude method m1OfB...");
	}
	@Test
	public void m2OfB() {
		System.out.println("Insude method m2OfB...");
	}
	@Test(groups = "Second group")
	public void m3OfB() {
		System.out.println("Insude method m3OfB...");
	}
	@Test
	public void m4OfB() {
		System.out.println("Insude method m4OfB...");
	}
}
