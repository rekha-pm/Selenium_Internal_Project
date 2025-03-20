package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.CategoryPage;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import utilities.RandomDataUtility;

public class CategoryPageTestCases extends BaseClass{
	
	LoginPage lp; 
	DashBoardPage dbp; 
	CategoryPage cp;
	
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "successfulLogIn")
  public void verifyTheAddCategoryFunctionality(String uName,String pW) {
	  lp = new LoginPage(driver);
	  dbp = lp.logIn(uName, pW);
	  cp = dbp.navigateToCategoryPage();
	  //cp.addCategory("mouse","C:\\Users\\REKHA PM\\Desktop\\ComputerMouse.jpeg");
	  String strCategoryname = RandomDataUtility.getCategoryName();
	  System.out.println("RandomCategoryName: " +strCategoryname);
	  cp.addCategory(strCategoryname);
	  String actual_SuccessMessage = cp.vefifySuccessMessageAfterCategoryCreation();
	  System.out.println("Message After category Creation:" +actual_SuccessMessage);
	  Assert.assertTrue(actual_SuccessMessage.contains("Category Created Successfully"));
  }
  

  
  
  
}
