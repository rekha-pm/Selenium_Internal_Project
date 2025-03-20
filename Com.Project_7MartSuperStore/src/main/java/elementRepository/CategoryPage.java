package elementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CategoryPage {
	
	WebDriver driver;
    GeneralUtilities gu = new GeneralUtilities();
    

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@onclick,'click_button(1)')]")
	WebElement newButton;
	@FindBy(xpath="//input[@id='category']")
	WebElement categorytextBox;
	@FindBy(xpath="//li[@id='134-selectable']")
	WebElement discountGroup;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	WebElement caegoryCreationSuccessMesssage;
	
	
	
	
	
	
	
	/*
	 * public void addCategory(String categoryName, String filePath) {
	 * newButton.click(); String renadomCategoryName = categoryName +
	 * gu.createRandomNumber_Utility();
	 * categorytextBox.sendKeys(renadomCategoryName); discountGroup.click();
	 * gu.fileUpload_Utility(chooseFileButton, filePath);
	 * gu.scrollUsingJavaScriptExecutor_Utility(driver, saveButton);
	 * gu.clickUsingJavaScriptExecutor_Utility(driver, saveButton);
	 * 
	 * }
	 */
	 
	
	public void addCategory(String categoryName) {
		newButton.click();
		categorytextBox.sendKeys(categoryName);
		//gu.scrollUsingJavaScriptExecutor_Utility(driver, saveButton);
		//gu.clickUsingJavaScriptExecutor_Utility(driver, saveButton);
		saveButton.click();
		
	}
	
	
	public String vefifySuccessMessageAfterCategoryCreation() {
		return gu.getTextOfElement_Utility(caegoryCreationSuccessMesssage);
	}
	
	

}
