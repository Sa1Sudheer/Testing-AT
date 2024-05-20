package glue;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Common_Functions
{
	static int sscount = 0;
	public static WebDriver OpenURL(String url, String mode)
	{
		System.setProperty("webdriver.gecko.driver","/snap/bin/firefox.geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--kiosk");
		if(mode.equals("headless"))
		{
			options.addArguments("--headless");
		}
		WebDriver driver = new FirefoxDriver(options);
		driver.get(url);
		System.out.println("Navigated to URL:"+url);
		return driver;
	}
	public static void captureScreenshot(WebDriver d, String ssName) throws Exception
    {
		File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"/home/abhi/eclipse-workspace/AutomationScreenshots/"+(sscount++)+"_"+ssName+".jpg"));
		System.out.println("Captured Screenshot:"+ssName+".jpg");
	}
}