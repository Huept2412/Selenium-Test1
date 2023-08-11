import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	private WebDriverWait wait;
	private WebDriver driver;
	
	 public loginPage(WebDriver driver) {
			this.driver = driver;
			 wait = new WebDriverWait(driver, 30);  // cài đặt thời gian tải trang không quá 30s
	}
	 
	   public void enterEmail(String email) throws InterruptedException {
	     WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PropertiesFileUtils.getProperty("inputEmail_name"))));
	     inputEmail.sendKeys(email);
	            
	        Thread.sleep(2000);
	    }

	  public void enterPassword(String password) throws InterruptedException   {
	       WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PropertiesFileUtils.getProperty("inputPass_name"))));
	        inputPassword.sendKeys(password);
	       Thread.sleep(2000);
	    }
 
		
		public void clickLogin() throws IOException {
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFileUtils.getProperty("login_xpath"))));
			loginButton.click();
		}

}

