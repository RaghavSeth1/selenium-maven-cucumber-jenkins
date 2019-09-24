package stepDefinition;
import pageFactory.*;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SmokeTest  {
	//WebDriver driver;
	static WebDriver driver;
	Login_page_Objects LoginPage = PageFactory.initElements(driver, Login_page_Objects.class);
	@Before
    public void beforeScenario()
	{
        System.out.println("Launching Browser Before executing Tests");        
    		 //String driverPath = "C:\\SeleniumPOC\\Drivers\\";
    		 System.out.println("Launching Browser");
    		 //System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
    		 String path = System.getProperty("user.dir");
    		 System.out.println(path); 
    		 System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromeDriver\\chromedriver.exe");
    		 driver = new ChromeDriver();    
    }  
 @After
    public void afterScenario()
    {
        System.out.println("Quit Browser after test completion");
        driver.quit();
    }	
		
	@When("^Start application$")
	public void startApplication() throws Throwable {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}

	@Then("^Correct title should be displayed$")
	public void validateCorrectTitle() throws Throwable {
		assertTrue(driver.getTitle().contains("OrangeHRM"));
	    
	}
	//Check before logging in that page is displayed
	@Given("^Login Page Navigated$")
	public void Login_Page_Navigated() throws Throwable {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	   
	}

	@Given("^I enter following for Login and click login button$")
	public void enterCredentialsandLogin(DataTable arg1) throws Throwable {
		LoginPage.txtbx_UserName.sendKeys("Admin");
		LoginPage.txtbx_Password.sendKeys("admin123");
		LoginPage.btn_Login.click();
	    
	}

	@Then("^I should see the Dashboard Page$")
	public void I_should_see_the_Dashboard_Page() throws Throwable {
		
		if(driver.findElement(By.id("menu_dashboard_index")).isDisplayed()== true){
			System.out.println("Dashboardplay");
			
		}
	    
	}

}
