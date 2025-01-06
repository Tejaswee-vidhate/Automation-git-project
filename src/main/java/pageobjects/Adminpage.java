package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminpage {

	
	WebDriver ldriver;
	
	public Adminpage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//used to initialize web Element of respective page object
		
	}
	//in java project
	//WebElement email=ldriver.findElement(By.xpath("//input[@id='Email']"));
	
	//in maven project 
	@FindBy(xpath="//input[@id='Emaillllll']") WebElement textEmail;
	
	@FindBy(xpath="//input[@id='Password']") WebElement textPassword;
	
	@FindBy(xpath="//button[text()='Log in']") WebElement btnLogin;
	
	// user defined method to perform operation on web element
	public void setEmail(String email) {
		textEmail.clear();
		textEmail.sendKeys(email);
	}
	public void setPassword(String pass) {
		textPassword.clear();
		textPassword.sendKeys(pass);
		
	}
	public void ClickOnLogin() {
	
		btnLogin.click();
	
}
}
