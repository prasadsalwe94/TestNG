package annotationTest2;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testngreport.ReportClass;
import testngreport.Retry;
@Listeners(ReportClass.class)
public class ClassD {
	@Test(groups="First group",expectedExceptions=NullPointerException.class)
	public void m1OfD(){
		String s =null;
		s.charAt(0);
		System.out.println("Insude method m1OfD...");
	}
	@Test(groups="First group")
	public void m2OfD(){
		System.out.println("Insude method m2OfD...");
	}
	@Test(groups="Second group", dependsOnMethods="m1OfD",alwaysRun=true)
	public void m3OfD(){
		System.out.println("Insude method m3OfD...");
	}
	@Test(dependsOnMethods="m5OfD")
	public void m4OfD(){
		System.out.println("Insude method m4OfD...");
	}
	@Test(expectedExceptions=NullPointerException.class)
	public void m5OfD(){
		String s1 =null;
		s1.charAt(0);
		System.out.println("Insude method m5OfD...");
	}
	@Test(retryAnalyzer = Retry.class)
	public void m6OfD(){
		System.out.println("inside m6 of D");
//	  	Assert.assertEquals(2+1, 4,"Addition should be equals to 4");
	}
}
   