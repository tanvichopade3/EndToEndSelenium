package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		// here this.driver is variable which we declare above and only driver which has
		// life gets passed from homePage class
	}

	By email = By.id("user_email");
	By password = By.name(" password");
	By log_in_button = By.cssSelector("input[type='submit']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(log_in_button);
	}
}
