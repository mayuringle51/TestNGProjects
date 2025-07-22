package LoginByDataProviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class saucedemo {
	WebDriver driver ;
	
	@BeforeMethod
	public void setup(){
		String USERNAME = "mayur_X5qSjd";
		String ACCESS_KEY = "xK88P229VbyaLSWcRyye";

		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
		
	}
	
	@Test(dataProvider="loginCredentials")	
	public void login(String username, String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		
	}
	
    @DataProvider(name = "loginCredentials")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"locked_out_user", "secret_sauce"},
            {"performance_glitch_user", "secret_sauce"}
        };
    }
	
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
