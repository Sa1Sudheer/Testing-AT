package glue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
Test Case Objective: Open Sauce Demo, View Backpack and purchase it.
*/
public class Case_002_SauceDemo_BuyBackpack
{
	public static void main(String args[]) throws Throwable
	{
		WebDriver driver = Common_Functions.OpenURL("https://www.saucedemo.com/","headless");
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle is: "+pageTitle);
		Common_Functions.captureScreenshot(driver,"LoginPage");
		
		//Login
		String username = "standard_user";
		String password = "secret_sauce";
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Common_Functions.captureScreenshot(driver,"LoginDetails_Captured");
		driver.findElement(By.id("login-button")).click();
		Common_Functions.captureScreenshot(driver,"LoggedIn");
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//View Backpack and Add to Cart
//		driver.findElement(By.id("item_4_title_link")).click();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		Common_Functions.captureScreenshot(driver,"ViewBackpack");
		driver.findElement(By.id("add-to-cart")).click();
		Common_Functions.captureScreenshot(driver,"AddToCart");
		driver.findElement(By.className("shopping_cart_link")).click();
		Common_Functions.captureScreenshot(driver,"ViewCart");
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("Princess");
		driver.findElement(By.id("last-name")).sendKeys("Peach");
		driver.findElement(By.id("postal-code")).sendKeys("Mario Land");
		Common_Functions.captureScreenshot(driver,"CheckoutInfo");
		
		driver.findElement(By.id("continue")).click();
		Common_Functions.captureScreenshot(driver,"Continue_Clicked");
		
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		Common_Functions.captureScreenshot(driver,"Order_Successful");
		
        driver.quit();
	}
}
