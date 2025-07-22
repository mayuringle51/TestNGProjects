package LoginByParameters;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunctionality {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@Test
	@Parameters({ "username", "password" })
	public void login(String username, String password) {

		WebElement userName = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submit"));

		userName.sendKeys(username);
		passWord.sendKeys(password);
		submit.click();

		System.out.println(driver.findElement(By.cssSelector(".post-title")).getText());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
