package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String projectPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// String browserName = prop.getProperty("browser");

		// if want to do parameterization from maven command
		// mvn test -Dbrowser = chrome
		// u need to comment String browserName = prop.getProperty("browser");
		// and add
		String browserName = System.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\D Drive\\Tanvi Data\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\D Drive\\Tanvi Data\\selenium\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		// we need to use .equal as == will not work as it return object and == can not.
		// == is a reference comparison, i.e. both objects point to the same memory
		// location
		// .equals() evaluates to the comparison of values in the objects

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}
}
