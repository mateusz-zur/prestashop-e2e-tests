package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {
	private static WebElement element = null;
	private static WebDriver driver = null;
	public static String correctLogin = "asasasas";
	public static String incorrectLogin = "asasasas";
	public static String correctPassword = "asasasas";
	public static String incorrectPassword = "asasasas";
	
	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement passwd(WebDriver driver) {
		element = driver.findElement(By.id("passwd"));
		return element;
	}
	public static WebElement submitLogin(WebDriver driver) {
		element = driver.findElement(By.id("SubmitLogin"));
		return element;
	}
	public static WebElement errorLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='center_column']/div[1]"));
		return element;
	}
	public static WebElement isLogged(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[text()[contains(.,'Bbb aaa')]]"));
		return element;
	}
}
