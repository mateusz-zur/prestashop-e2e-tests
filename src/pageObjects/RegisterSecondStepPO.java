package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterSecondStepPO {
	private static WebElement element = null;
	private static WebDriver driver = null;
	
	public static WebElement customer_firstname(WebDriver driver) {
		element = driver.findElement(By.id("customer_firstname"));
		return element;
	}
	public static WebElement customer_lastname(WebDriver driver) {
		element = driver.findElement(By.id("customer_lastname"));
		return element;
	}
	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement passwd(WebDriver driver) {
		element = driver.findElement(By.id("passwd"));
		return element;
	}
	public static WebElement days(WebDriver driver) {
		element = driver.findElement(By.id("days"));
		return element;
	}
	public static WebElement submitAccount(WebDriver driver) {
		element = driver.findElement(By.id("submitAccount"));
		return element;
	}
	
	
	
	//To verification correct background-color for inputs. 
		public static String customer_firstnameCss(WebDriver driver) {
			String element2 = driver.findElement(By.id("customer_firstname")).getCssValue("backgroud-color");
			return element2;
		}
		public static String customer_lastnameCss(WebDriver driver) {
			String element2 = driver.findElement(By.id("customer_lastname")).getCssValue("backgroud-color");
			return element2;
		}
		public static String emailCss(WebDriver driver) {
			String element2 = driver.findElement(By.id("email")).getCssValue("backgroud-color");
			return element2;
		}
		public static void passwdCss(WebDriver driver) {
			String element2 = driver.findElement(By.id("passwd")).getCssValue("backgroud-color");
			System.out.println(element2);
		}
}
