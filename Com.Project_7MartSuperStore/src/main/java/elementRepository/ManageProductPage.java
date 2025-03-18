package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProductPage {
	
	WebDriver driver;
    GeneralUtilities gu = new GeneralUtilities();
    WaitUtility wu = new WaitUtility();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(xpath ="//a[contains(text(),'Search')]")
	 WebElement searchButton_Blue;
	 @FindBy(xpath="//input[contains(@placeholder,'Product')]")
	 WebElement productCodeTextBox;
	 @FindBy(xpath="//button[contains(@class,'btn-danger')]")
	 WebElement productSearchButton_Red;
	 @FindBy(xpath="//table/tbody/tr/td/button")
	 WebElement productNameResult;
	 @FindBy(id="cat_id")
	 WebElement CategoryDropDown;
	 
      public void productSearch(String pCode) {
    	  searchButton_Blue.click();
    	  productCodeTextBox.sendKeys(pCode);
    	  productSearchButton_Red.click();
	 }

	 public String getTextOfResultProductName() {
		 	wu.waitForElementToBeVisibleByElement_Utility(productNameResult, 2000);
			return gu.getTextOfElement_Utility(productNameResult);
	}
	 
	 public List<String> getAllOptionsfromCategoryDropdown(){
		 searchButton_Blue.click();
		 return gu.getAllDropDownOptions_Utility(CategoryDropDown);
	 }
	 
	 
	 
}
