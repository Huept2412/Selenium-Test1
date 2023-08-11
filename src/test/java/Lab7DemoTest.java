import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7DemoTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String URL = PropertiesFileUtils.getProperty("base_url");
		driver.get(URL);
		wait = new WebDriverWait(driver, 30);

	}

	@Test(priority = 0)
	public void TC01_LoginFirstAccount() throws Exception{
		
		String email1 = PropertiesFileUtils.getProperty("email_1");
		String password1 = PropertiesFileUtils.getProperty("password_1");
		System.out.println("email1:"+email1+" and password1 :"+password1);
		WebElement signInButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(PropertiesFileUtils.getProperty("icon_Signin_xpath"))));
		signInButton.click();
		loginPage login = new loginPage(driver);
		PageFactory.initElements(driver, login);
		login.enterEmail(email1);
		login.enterPassword(password1);
		login.clickLogin();
		WebElement signoutButton = driver.findElement(By.xpath(PropertiesFileUtils.getProperty("icon_Signout_xpath"))); //
		Assert.assertEquals(true, signoutButton.isDisplayed(), "Sign out Button is not displayed");
		signoutButton.click();
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void TC02_LoginSecondAccount() throws Exception{
		
		String email2 = PropertiesFileUtils.getProperty("email_2");
		String password2 = PropertiesFileUtils.getProperty("password_2");
		System.out.println("email1:"+email2+" and password1 :"+password2);
		WebElement signInButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(PropertiesFileUtils.getProperty("icon_Signin_xpath"))));
		signInButton.click();
		loginPage login = new loginPage(driver);
		PageFactory.initElements(driver, login);
		login.enterEmail(email2);
		login.enterPassword(password2);
		login.clickLogin();
		WebElement signoutButton = driver.findElement(By.xpath(PropertiesFileUtils.getProperty("icon_Signout_xpath"))); //
		Assert.assertEquals(true, signoutButton.isDisplayed(), "Sign out Button is not displayed");
		signoutButton.click();
		Thread.sleep(2000);
	}



@AfterMethod //
public void takeScreenshot(ITestResult result) throws InterruptedException {
	  Thread.sleep(1000);
	  // Nếu kết quả failed thì chụp lại màn hình
	  if (ITestResult.FAILURE == result.getStatus()) {
	    try {
	        CaptureScreenshot.takeScreenshot(driver, result.getName());
	        System.out.println("Đã chụp màn hình: " + result.getName());
	    } catch (Exception e) {
	        System.out.println("Exception while taking screenshot " + e.getMessage());
	    }
	  }  
	}
	  @AfterClass // 
	  public void closeDriverInstance() {
		  driver.quit(); 
} 
	  }
