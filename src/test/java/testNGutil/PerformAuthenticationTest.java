package testNGutil;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appcontroller.EmpController;
import excelReadWrite.ExcelRead;
 
public class PerformAuthenticationTest {
	@DataProvider
	public Object[][] getTestData(){
		return ExcelRead.readDatafromExcel();
	}
	@Test(dataProvider="getTestData")
	public void performLogin(String Name,String pwd,String ExMsg){
		System.out.println(Name+"--"+pwd+"--"+ExMsg);
		EmpController empC= new EmpController();
		String actualMsg=empC.validateUserCredentials(Name, pwd);
		Assert.assertEquals(actualMsg, ExMsg);
	}
}
