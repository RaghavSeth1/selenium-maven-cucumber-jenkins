package stepDefinition;
import pageFactory.Login_page_Objects;
import otherUtilities.*;
import pageFactory.Home_page_Objects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SmokeTest  {
	WebDriver driver;
	
	Login_page_Objects loginPage;
	CommonFunctions common=new CommonFunctions();
	Screenshots shot = new Screenshots();
	Home_page_Objects homePage;
	
	@Before
	public void beforeScenario()
	{	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromeDriver77\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@After
    public void afterScenario(Scenario scenario) 
    {
        System.out.println("Quit Browser after test completion");
        if (scenario.isFailed()){
        	Screenshots.captureScreenShot(driver);
        }
        
        driver.quit();
    }	

	@When("^Start application$")
	public void startApplication(){
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}

	@Then("^Correct title should be displayed$")
	public void validateCorrectTitle() throws Throwable {
		assertTrue(driver.getTitle().contains("OrangeHRM"));

	}

	@Given("^Login Page Navigated$")
	public void navigateLoginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" on Login page and click login button$")
	public  void loginwithAdmin(String userName, String password) {
		loginPage=new Login_page_Objects(driver);
		
		loginPage.setUsername(userName);
		loginPage.setPassword(password);
		loginPage.loginClick();
	}

	@Then("^I should see the Dashboard Page$")
	public void validateLoginSuccessfull(){			
		homePage=new Home_page_Objects(driver);
		
		if(homePage.home_welcomeIcon.isDisplayed()== true){
			System.out.println("Login Successfull");

		}
	}
	@Then("^Logout of the Application$")
	public void logoutApplication() {
		homePage=new Home_page_Objects(driver);
		
		homePage.home_welcomeIcon.click();
		common.explicitWait(homePage.link_Logout, 10, driver);
		homePage.link_Logout.click();

	}

}
