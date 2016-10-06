package testCases;
import pageObjects.Global;
import pageObjects.LoginPO;
import pageObjects.RegisterFirstStepPO;
import pageObjects.RegisterSecondStepPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterPageFieldsTest {
		public WebDriver driver;
		public WebElement element2;
		
		//Verification if entered email is real email - NEGATIVE
		@Test
		public void verytifyEmailError() {
			driver.get(Global.mainURL + "login");
			RegisterFirstStepPO.email_create(driver).sendKeys("failemail");
			RegisterFirstStepPO.createAccountButton(driver).click();
			RegisterFirstStepPO.emailRegisterFieldError(driver);	
		}
		
		//Verification if entered email is real email - POSITIVE
		@Test 
		public void verytifyEmailOk() {
			driver.get(Global.mainURL + "login");
			RegisterFirstStepPO.email_create(driver).sendKeys("zurrek@gmail.com");
			RegisterFirstStepPO.createAccountButton(driver).click();
			WebElement myDynamicElement = (new WebDriverWait(driver, 2))
			.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
		}
		
		//Verification if required fields aren't empty - NEGATIVE
		@Test
		public void emptyFieldsError() {
			verytifyEmailOk();
			WebElement customer_firstname = RegisterSecondStepPO.customer_firstname(driver);
			customer_firstname.click();
			
			WebElement customer_lastname = RegisterSecondStepPO.customer_lastname(driver);
			customer_lastname.click();
			
			WebElement email = RegisterSecondStepPO.email(driver);
			email.click();
			email.clear();
			
			WebElement passwd = RegisterSecondStepPO.passwd(driver);
			passwd.click();
			
			RegisterSecondStepPO.days(driver).click();
		
			Assert.assertEquals(customer_firstname.getCssValue("background-color"), "rgb(255, 241, 242)");
			Assert.assertEquals(customer_lastname.getCssValue("background-color"), "rgb(255, 241, 242)");
			Assert.assertEquals(email.getCssValue("background-color"), "rgb(255, 241, 242)");
			Assert.assertEquals(passwd.getCssValue("background-color"), "rgb(255, 241, 242)");
		}
		
		//Verification if required fields aren't empty - POSITIVE
		@Test
		public void EmptyFieldsOk() {
			verytifyEmailOk();
			WebElement customer_firstname = RegisterSecondStepPO.customer_firstname(driver);
			customer_firstname.sendKeys("Mateusz");
			
			WebElement customer_lastname = RegisterSecondStepPO.customer_lastname(driver);
			customer_lastname.sendKeys("¯ur");
			
			WebElement email = RegisterSecondStepPO.email(driver);
			email.click();
			
			WebElement passwd = RegisterSecondStepPO.passwd(driver);
			passwd.sendKeys("veryverysafetypassword");
			
			RegisterSecondStepPO.days(driver).click();
		
			Assert.assertEquals(customer_firstname.getCssValue("background-color"), "rgb(221, 249, 225)");
			Assert.assertEquals(customer_lastname.getCssValue("background-color"), "rgb(221, 249, 225)");
			Assert.assertEquals(email.getCssValue("background-color"), "rgb(221, 249, 225)");
			Assert.assertEquals(passwd.getCssValue("background-color"), "rgb(221, 249, 225)");
		}
		
		@BeforeTest
		public void BeforeTest() {
			Global.setGecko();
		}
		
		@BeforeMethod
		public void BeforeMethod () {
			driver = new FirefoxDriver();
		}
		
		@AfterTest
		public void AfterSuite() {
			driver.quit();
		}
}
