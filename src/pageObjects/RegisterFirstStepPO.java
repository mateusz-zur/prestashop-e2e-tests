package pageObjects;
import pageObjects.LoginPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterFirstStepPO {
	private static WebElement element = null;
	private static WebDriver driver = null;
	
	public static WebElement email_create(WebDriver driver) {
		element = driver.findElement(By.id("email_create"));
		return element;
	}
	public static WebElement createAccountButton(WebDriver driver) {
		element = driver.findElement(By.id("SubmitCreate"));
		return element;
	}
	public static WebElement emailRegisterFieldError(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='create-account_form']/div/div[2]"));
		return element;
	}
	public static WebElement createAccountError(WebDriver driver) {
		element = driver.findElement(By.id("create_account_error"));
		return element;
	}
	
}
