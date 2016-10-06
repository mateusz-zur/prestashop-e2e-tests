package testCases;
import pageObjects.Global;
import pageObjects.RegisterFirstStepPO;
import pageObjects.RegisterSecondStepPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class RegisterAccountTest {
	public WebDriver driver;
	public static WebElement element;
	private static String fname = "bbb";
	private static String lname = "aaa";
	
	@Test
	public void register() {
		driver.get(Global.mainURL + "login");
		RegisterFirstStepPO.email_create(driver).sendKeys("zurrek5@gmail.com");
		RegisterFirstStepPO.createAccountButton(driver).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 2))
		.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
		RegisterSecondStepPO.customer_firstname(driver).sendKeys(fname);
		RegisterSecondStepPO.customer_lastname(driver).sendKeys(lname);
		RegisterSecondStepPO.passwd(driver).sendKeys("tajnehaslo");
		RegisterSecondStepPO.submitAccount(driver).click();
		isLogged(driver);
	}
	
	@Test
	public void registedTakenEmail() {
		driver.get(Global.mainURL + "login");
		RegisterFirstStepPO.email_create(driver).sendKeys("zurrek2@gmail.com");
		RegisterFirstStepPO.createAccountButton(driver).click();
		RegisterFirstStepPO.createAccountError(driver);
	}	
	
	public static WebElement isLogged(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[text()[contains(.,'" + fname + " " + lname + " ')]]"));
		return element;
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