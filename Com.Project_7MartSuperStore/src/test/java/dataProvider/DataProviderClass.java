package dataProvider;

import org.testng.annotations.Test;

import utilities.ExcelRead;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	  @DataProvider (name = "successfulLogIn")
	  public Object[][] dp1() throws IOException {
	    return new Object[][] {
	      new Object[] { ExcelRead.getStringData(0, 0),ExcelRead.getStringData(0, 1) },
	      };
	  }
  
  @DataProvider (name = "unSuccessfulLogIn")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { "admi","admin" },
      new Object[] { "admin", "admin2"},
      new Object[] { "admin2","admin2"}
    };
  }
  
  
  @DataProvider (name = "searchProduct")
  public Object[][] dp3() {
    return new Object[][] {
      new Object[] { "454" },
      
    };
  }
  
  
  
}
