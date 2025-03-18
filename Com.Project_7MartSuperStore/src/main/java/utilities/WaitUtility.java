package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriverWait wait;
	WebDriver driver;
	

	public void waitForElementToBeClickableByXpathLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	public void waitForElementToBeClickableByIdLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}
	
	
	public void waitForElementToBeVisibleByElement_Utility(WebElement element,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeVisibleByXpathLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
	}
	
	public void waitForElementToBeVisibleByIdLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
	}
	
	public void waitForPrecenceOfElementByXpathLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}
	
	public void waitForPrecenceOfElementByIdLocator_Utility(String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}
	
	public void waitForAlert_Utility(int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
		
	public void fluentWaitForElementtoBeClickableByXpathLocator_Utility(String locatorValue,int totalTimeOut,int pollingTimeOut ) {
		
		FluentWait<WebDriver> wait = new FluentWait<> (driver)
				.withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	public void fluentWaitForElementtoBeClickableByIdLocator_Utility(String locatorValue,int totalTimeOut,int pollingTimeOut ) {
		
		FluentWait<WebDriver> wait = new FluentWait<> (driver)
				.withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}


}
