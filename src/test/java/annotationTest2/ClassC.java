package annotationTest2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testngreport.ReportClass;
@Listeners(ReportClass.class)

public class ClassC {
	@Test
	public void m1OfC(){
		System.out.println("Insude method m1OfC...");
	}
	@Test
	public void m2OfC(){
		System.out.println("Insude method m2OfC...");
	}
	@Test(groups="Second group")
	public void m3OfC(){
		System.out.println("Insude method m3OfC...");
	}
	@Test
	public void m4OfC(){
		System.out.println("Insude method m4OfC..."+10/0);
	}
}
