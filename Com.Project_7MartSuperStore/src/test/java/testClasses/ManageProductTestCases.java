package testClasses;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductTestCases extends BaseClass{
	
	
	  LoginPage lp; 
	  DashBoardPage dbp; 
	  ManageProductPage mpp;
	 
	
	
  @Test(dataProviderClass = DataProviderClass.class,dataProvider = "searchProduct",groups = "Group1" )
  public void verifyTheSeachFunctionality(String pCode) {
	  lp = new LoginPage(driver);
	  dbp = lp.logIn("admin", "admin");
	  mpp = dbp.navigateToManageProductPage();
	  mpp.productSearch(pCode);
	  String actual_ProductName = mpp.getTextOfResultProductName();
	  System.out.println("Actual Result Product name: " +actual_ProductName);
	  Assert.assertTrue(actual_ProductName.contains("P"+pCode));
	  //Assert.assertTrue(actual_ProductName.contains("P"+pCode) && actual_ProductName.contains("Harpic"));
  }
  
  @Test
  public void verifyAllOptionsFromCategoryDropdown() {
	  lp = new LoginPage(driver);
	  dbp = lp.logIn("admin", "admin");
	  mpp = dbp.navigateToManageProductPage();
	  //List<String> expected_resultList = List.of(Select, veggies, Accessories, Fresh_fruits, Toys, Vegetables, burger, Kala, Electronics, non veg, Beetroot, Pen130125063755kp, Have a nice day, biscuit, DriedFruitsm, Edited211224025455, Rose, Mary, Card070125075222, Card070125075324, Card070125075525, Card070125075616, iphone, Beetroot, Icecream, avcmmmmmmmmmmmm, Card070125080848, Card080125083926, Card080125115306, Card080125115422, MacBook, Card080125120246, Card080125015229, Electronic_Device090125091347, Card090125015659, DriedFruits120125114847, Card120125065324kp, phone120125075428, test, Pen120125102413kp, SamSung_S24_Ultra_8281SamSung_S24_Ultra_New, qwertyu, Private JOBS, bagsling bag120325105433MobileMobileMobile, Mobile120325050407MobileMobileMobileMobile, Mobile, sling bag130325073249, sling bag130325104504Mobile010170053000, Mobile130325110520010170053000Mobile010170053000Mobile010170053000Mobile010170053000, Mobile010170053000Mobile010170053000, Mobile010170053000, jewels, BeautyProducts, Private JOBS, Private JOBS, Private JOBS, Pen130125124333kp, jewellery140125075343, Laysgree, Pen150125082812new, SamSung_S24_Ultra_8281_New, jewellery160125100552, SamSung_S24_Ultra_8281_New, Pen220125060613new, Fashion190225032014, Fashion010325113025, HandBagsMobile010170053000, IT JOBS);
	  List<String> expected_resultList = Arrays.asList("Select","veggies", "Accessories", "Fresh_fruits", "Toys", "Vegetables", "burger", "Kala", "Electronics", "non veg", "Beetroot", "Pen130125063755kp", "Have a nice day", "biscuit", "DriedFruitsm", "Edited211224025455", "Rose, Mary", "Card070125075222", "Card070125075324", "Card070125075525", "Card070125075616", "iphone", "Beetroot", "Icecream", "avcmmmmmmmmmmmm", "Card070125080848", "Card080125083926", "Card080125115306", "Card080125115422", "MacBook", "Card080125120246", "Card080125015229", "Electronic_Device090125091347", "Card090125015659", "DriedFruits120125114847", "Card120125065324kp", "phone120125075428", "test", "Pen120125102413kp", "SamSung_S24_Ultra_8281SamSung_S24_Ultra_New", "qwertyu", "Private JOBS", "bagsling bag120325105433MobileMobileMobile", "Mobile120325050407MobileMobileMobileMobile", "Mobile", "sling bag130325073249", "sling bag130325104504Mobile010170053000", "Mobile130325110520010170053000Mobile010170053000Mobile010170053000Mobile010170053000", "Mobile010170053000Mobile010170053000", "Mobile010170053000", "jewels", "BeautyProducts", "Private JOBS", "Private JOBS", "Private JOBS", "Pen130125124333kp", "jewellery140125075343", "Laysgree", "Pen150125082812new", "SamSung_S24_Ultra_8281_New", "jewellery160125100552", "SamSung_S24_Ultra_8281_New", "Pen220125060613new", "Fashion190225032014", "Fashion010325113025", "HandBagsMobile010170053000", "IT JOBS");
	  List<String> actual_resultList = mpp.getAllOptionsfromCategoryDropdown();
	  System.out.println(actual_resultList);
	  Assert.assertEquals(actual_resultList, expected_resultList);
  }
  
  
}


  