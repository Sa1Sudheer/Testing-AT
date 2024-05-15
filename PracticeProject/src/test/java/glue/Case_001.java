package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Case_001
{
	WebDriver driver;
	
	@Given("^Open Browser For URL ([^\\\"]*)$")
	public void OpenBrowserForURL(String url) throws Throwable
	{
		System.setProperty("webdriver.gecko.driver","/snap/bin/firefox.geckodriver");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("^User enters correct username and password values ([^\\\"]*) ([^\\\"]*)$")
	public void Login_With_Id_Password(String id, String pwd) throws Throwable
	{
		
	}

	@Then("^Check Website Title ([^\\\"]*)$")
	public void Check_Website_Title(String title) throws Throwable
	{		
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(title))
            System.out.println("Title Matched!");
        else
            System.out.println("Title Not Matched");	
	}
}
