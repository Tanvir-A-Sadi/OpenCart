package baseClasses;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassOpencart {
	
	public WebDriver driver;
	public Properties properties;
	public Logger logger;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"master", "sanity", "regression"})
	@Parameters({"browser", "os"})
	public void setup(String br, String executionOS) throws IOException {
		
		FileReader fileReader = new FileReader(".//src/test/resources/config.properties");
		properties = new Properties();
		properties.load(fileReader);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(executionOS.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(executionOS.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" : capabilities.setBrowserName("chrome"); break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox" : capabilities.setBrowserName("firefox"); break;
		default: System.out.println("No matching browser.."); return;
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
	    }
		else if(properties.getProperty("execution_env").equalsIgnoreCase("local")){
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();			
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No browser found!");
				return;
			}
		}
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = {"master", "sanity", "regression"})
	public void tearDown() {
		driver.quit();
	}

	public String generateRandomAlphabetic(int i) {
		return RandomStringUtils.randomAlphabetic(i);
	}
	public String generateRandomAlphaNumeric(int i) {
		return RandomStringUtils.randomAlphanumeric(i);
	}
	public String generateRandomNumeric(int i) {
		return RandomStringUtils.randomNumeric(i);
	}
	public String generateRandomEmail(String email) {
		return email + "@gmail.com";
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
}
