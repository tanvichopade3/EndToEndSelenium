package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	public landingPage(WebDriver driver) {
		this.driver = driver;
		// here this.driver is variable which we declare above and only driver which has
		// life gets passed from homePage class
	}

	// with declaring the privet variable and public methods we are achieving
	// encapsulation
	private By loginHomePageLink = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector("div[class='text-center'] h2");
	private By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By moneyGuaTitle = By.cssSelector("div[class*='col-sm-12'] div[class*='col-sm-9'] h3");

	public WebElement getLogin() {
		return driver.findElement(loginHomePageLink);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
	
	public WebElement getMoneyGuaranteeTitle() {
		return driver.findElement(moneyGuaTitle);
	}

}
