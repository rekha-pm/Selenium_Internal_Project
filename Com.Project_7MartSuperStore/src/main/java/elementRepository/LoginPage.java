package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	
	GeneralUtilities gu = new GeneralUtilities();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'7rmart')]") 
	WebElement label7rmartSupermarcketl;
	@FindBy(name = "username") 
	WebElement userNameTextBox;
	@FindBy(name = "password") 
	WebElement passWordTextBoxTextBox;
	@FindBy(name = "remember_me") 
	WebElement rememberMeCheckBox;
	//@FindBy(xpath = "//label[@for='remember']") 
	//WebElement rememberMeCheckBox;
	@FindBy(xpath = "//button[@type='submit']") 
	WebElement signInButton;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	WebElement invalidLogin;
	
	
	public String getTitleOfLogInPage() {
		return driver.getTitle();
	}
	
	public String getTextOf7MartHeading() {
		return gu.getTextOfElement_Utility(label7rmartSupermarcketl);
	}
	
	public DashBoardPage logIn(String uName,String pW) {
		userNameTextBox.sendKeys(uName);
		passWordTextBoxTextBox.sendKeys(pW);
		signInButton.click();
		//chaining of pages
		return new DashBoardPage(driver);
	}

	public String unSuccessfulErrorMessage() {
		return gu.getTextOfElement_Utility(invalidLogin);
	}
	
	public boolean isRememeberMeCheckBoxChecked() {
		
		return gu.IsSelectedElement_Utility(rememberMeCheckBox);
	}
	
	
	
}
