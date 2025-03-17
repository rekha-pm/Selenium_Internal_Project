package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoardPage {

	WebDriver driver;
    GeneralUtilities gu = new GeneralUtilities();
    

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[ @data-toggle='dropdown' ]")
	WebElement dashboardLogInName;
	@FindBy(xpath = "//div[contains(@class,'col-lg-3')]")
	List<WebElement> allTiles;
	@FindBy(xpath=("//nav[@class='mt-2']/child::ul/child::li[8]/child::a/child::p"))
	WebElement manageProductLink;
	@FindBy(xpath=("//div[@class='col-lg-3 col-6'][3]/child::div/child::a"))
	WebElement categoryProductLink;
	
	
	

	public String getTextOfDashboardLogInName() {
		return gu.getTextOfElement_Utility(dashboardLogInName);
	}

	public boolean IsAllTilesDisplayed() {

		for (WebElement tile : allTiles) {
			if (!gu.IsDisplayedElement_Utility(tile)) {
				return false;
			}
		}
		return true;
	}
	
	
	public ManageProductPage navigateToManageProductPage() {
		manageProductLink.click();
		//chaining of pages
		return new ManageProductPage(driver);
	}
	
	public CategoryPage navigateToCategoryPage() {
		categoryProductLink.click();
		//chaining of pages
		return new CategoryPage(driver);
	}
	
	
	

}
