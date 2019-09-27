package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home_page_Objects {
	WebDriver driver;



	@FindBy(how = How.ID , using = "welcome")
	public WebElement home_welcomeIcon;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT , using = "Logout")
	public WebElement link_Logout;
	
	
	//driver.findElement(By.linkText("View Profile")).click()
	
	
	public Home_page_Objects(WebDriver driver){ 		 
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	} 

}
