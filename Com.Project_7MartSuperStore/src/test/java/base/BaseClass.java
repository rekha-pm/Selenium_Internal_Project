package base;

import org.testng.annotations.BeforeMethod;

import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  
	public WebDriver driver;
	public static Properties property;

	public static void readProperty() throws IOException {
		
		 property = new Properties();
		 FileInputStream f = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\config\\config.properties");
		 property.load(f);
	}
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readProperty();
	  driver = new ChromeDriver();
	  driver.get(property.getProperty("base_url"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  

  @AfterMethod
  public void afterMethod() {
	
	 // driver.quit();
  }

}
