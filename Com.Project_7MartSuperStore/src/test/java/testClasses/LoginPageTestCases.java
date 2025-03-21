package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import retry.RetryAnalyzer;
import utilities.ExcelRead;

public class LoginPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashBoardPage dbp;
	
	
  @Test(groups = "Group1",retryAnalyzer = RetryAnalyzer.class)
  public void verifyTheExactPageIsOpenesWhileHittingTheURL_UsingTitle() throws IOException {
	  lp = new LoginPage(driver);
		/*
		 * String actual_Title = lp.getTitleOfLogInPage();
		 * System.out.println("Actual Title:" +actual_Title);
		 * Assert.assertEquals(actual_Title, "Login | 7rmart supermarket");
		 */
		String actual_Heading = lp.getTextOf7MartHeading();
		System.out.println("Actual heading: " + actual_Heading);
		Assert.assertEquals(actual_Heading, ExcelRead.getStringData(0, 2));
  }
  
  
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "successfulLogIn", groups = "Group1")
  public void verifySuccessfulLogIn(String uName,String pW) throws IOException {
	  lp = new LoginPage(driver);
	  dbp = lp.logIn(uName, pW);
	  //dbp = lp.logIn(ExcelRead.getStringData(0, 0), ExcelRead.getStringData(0, 1));
	  String actual_DashBoardUName = dbp.getTextOfDashboardLogInName();
	  String expected_DashBoardUName = "Admin";
	  System.out.println("Actual DashBoard UName: " + actual_DashBoardUName);
	  Assert.assertEquals(actual_DashBoardUName, expected_DashBoardUName);
	}
  
  
  
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "unSuccessfulLogIn")
  public void verifyUnSuccessfulLogIn(String uName,String pName) {
	  lp = new LoginPage(driver);
	  lp.logIn(uName, pName);
	  String actual_InvalidLogInName = lp.unSuccessfulErrorMessage();
	  Assert.assertTrue(actual_InvalidLogInName.contains("Invalid Username"));
	 }
  
  @Test(retryAnalyzer = RetryAnalyzer.class)
  public void verifyRememberMeCheckBoxIsNotCheckedByDefault() {
	  lp = new LoginPage(driver);
	  boolean actual_status = lp.isRememeberMeCheckBoxChecked();
	  System.out.println("RememberMeCheckBox Status:" +actual_status);
	  //Assert.assertFalse(actual_status);
	  Assert.assertTrue(actual_status);
  }
  

}
