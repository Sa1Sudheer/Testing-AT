package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleTestCase
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.gecko.driver","/snap/bin/firefox.geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		
		if (actualTitle.contentEquals(expectedTitle))
            System.out.println("Test Passed!");
        else
            System.out.println("Test Failed");
		
        driver.close();
		
	}
}
