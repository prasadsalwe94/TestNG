package annotationTest;

import org.testng.annotations.Test;

public class ClassA {
	@Test(groups="First group")
	public void m1OfA(){
		System.out.println("Insude method m1OfA...");
	}
	@Test(groups="First group")
	public void m2OfA(){
		System.out.println("Insude method m2OfA...");
	}
	@Test(groups="Second group")
	public void m3OfA(){
		System.out.println("Insude method m3OfA...");
	}
	@Test
	public void m4OfA(){
		System.out.println("Insude method m4OfA...");
	}
}
