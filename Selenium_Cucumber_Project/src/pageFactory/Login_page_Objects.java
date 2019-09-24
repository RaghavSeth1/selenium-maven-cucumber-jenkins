package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;


public class Login_page_Objects {
	//public static WebDriver driver=null;
	final WebDriver driver;
	@FindBy(how = How.ID , using = "txtUsername")
	public WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "txtPassword")	 
	 public WebElement txtbx_Password;
	 
	 @FindBy(how = How.NAME, using = "btnLogin")	 
	 public WebElement btn_Login ;
	 
	
	public Login_page_Objects(WebDriver driver){ 		 
	    this.driver = driver; 
	 
	    } 

}
