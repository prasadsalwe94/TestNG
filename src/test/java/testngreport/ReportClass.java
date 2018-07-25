package testngreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportClass implements ITestListener {
	static int passCaseCount=0;
	static int failCaseCount=0;
	static int SkipCaseCount=0; 
	@Override
	public void onTestStart(ITestResult result) {
			System.out.println("inside on test start.......");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("inside onsuccess"+result.getName());
		passCaseCount++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+"this test case failed..");
		failCaseCount++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println(result.getName()+"this testcase got skipped...");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("failed but within success.....");
	}
 
	@Override
	public void onStart(ITestContext context) {
		System.out.println("inside onsuitstart.....");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("inside suitFinish...");
		System.out.println("total case passed: "+passCaseCount);
		System.out.println("total case failed: "+failCaseCount);
		System.out.println("total case skipped: "+SkipCaseCount); 
		JfreeChart.pieChartReport(passCaseCount, failCaseCount, SkipCaseCount);
	}

}
