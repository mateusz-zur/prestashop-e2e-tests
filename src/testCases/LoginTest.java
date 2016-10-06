package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPO;
import pageObjects.Global;

public class LoginTest {
	public WebDriver driver;
	public WebElement element2;
	
	@Test
	public void login() {
		driver.get(Global.mainURL + "login");
		LoginPO.email(driver).sendKeys("zurrek3@gmail.com");
		LoginPO.passwd(driver).sendKeys("tajnehaslo");
		LoginPO.submitLogin(driver).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 2))
		.until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));
	}
	
	@Test
	public void loginBadPass() {
		driver.get(Global.mainURL + "login");
		LoginPO.email(driver).sendKeys("zurrek3@gmail.com");
		LoginPO.passwd(driver).sendKeys("tajnehaslo_zle");
		LoginPO.submitLogin(driver).click();
		LoginPO.errorLogin(driver);
	}
	
	@BeforeTest
	public void BeforeTest() {
		Global.setGecko();
	}

	@BeforeMethod
	public void BeforeMethod () {
		driver = new FirefoxDriver();
	}
}
