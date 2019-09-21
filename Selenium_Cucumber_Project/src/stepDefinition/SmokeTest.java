package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SmokeTest {
	
	WebDriver driver;
	@Given("^Open Chrome Browser$")
	public void Open_Chrome_Browser() throws Throwable {
		 String driverPath = "C:\\SeleniumPOC\\Drivers\\";
		 //C:\SeleniumPOC\drivers
		 System.out.println("Launching Browser");
		 System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
		 driver = new FirefoxDriver(); 
		 driver.navigate().to("https://www.google.com");
	    
	    
	}

	@When("^Start spplication$")
	public void Start_spplication() throws Throwable {
		driver.get("https://www.google.com");
	}

	@Then("^Correct title should be displayed$")
	public void Correct_title_should_be_displayed() throws Throwable {

	    
	}


}
