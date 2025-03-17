package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class DashBoardTestCases extends BaseClass{
	
	LoginPage lp;
	DashBoardPage dbp;
	
	
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "successfulLogIn")
  public void verifyAllTilesAreDisplayedOnDashBoardPage(String uName,String pW) {
	  
	  lp = new LoginPage(driver);
	  dbp = lp.logIn(uName, pW);
	  boolean actual_Result =dbp.IsAllTilesDisplayed();
	  Assert.assertTrue(actual_Result);
  }
  
  
  
}
