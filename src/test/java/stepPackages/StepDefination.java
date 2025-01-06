package stepPackages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Adminpage;
import utilities.Readconfig;

public class StepDefination extends Baseclass{

	@Before
	public void setup() throws Exception {
		System.out.println("this methos executes before each scenario");
		readconfig=new Readconfig();
		String browservalue=readconfig.getbrowser();//brower-firefox
		
		if(browservalue.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		} else if(browservalue.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browservalue.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		//driver=new ChromeDriver();
		//ssdriver.manage().window().maximize();
		admin=new Adminpage(driver);//create object of AdminPage
		Thread.sleep(2000);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
	   driver.get(url);
	   Thread.sleep(2000);
	    
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws Exception {
	    admin.setEmail(email);
	    Thread.sleep(2000);
	    admin.setPassword(password);
	    Thread.sleep(2000);
	}

	@When("User click login button")
	public void user_click_login_button() {
	   admin.ClickOnLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
	    
		Assert.assertEquals(title, "Dashboard/nopcommerce administration");
	}

	@Then("close  browser")
	public void close_browser() {
	    driver.quit();
	}
	
	@After
	public void teardown(Scenario sc) throws Exception{
		if (sc.isFailed()) {
		
		String filepath="C:\\Users\\Shree\\eclipse-workspace6\\BDDCucumberMavenProject3\\Screenshots\\Failedscreenshots.png";
		System.out.println("this method will execute after eachh scenarioo");
		//1.convert webdriver into take screenshot
		TakesScreenshot srcshot=(TakesScreenshot)driver;
		//2.call get screenshotAs
		File srcFile= srcshot.getScreenshotAs(OutputType.FILE);
	
		File destFile=new File(filepath);
		
		FileUtils.copyFile(srcFile, destFile);
		}
	}
}
