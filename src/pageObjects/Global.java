package pageObjects;
import org.testng.annotations.*;

public class Global {
	
	public static String mainURL = "http://test.mzur.pl/";
	
	public static void setGecko() {
		System.setProperty("webdriver.gecko.driver","E:\\workspace\\jars\\selenium\\geckodriver.exe");
	}
	
}
