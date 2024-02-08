package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;

public class BaseClass {
	static public WebDriver driver;
	
	public Properties p;
	public HomePage hp;
	public static Logger logger;
	
	@BeforeTest
	@Parameters({"br"})
	public void setup(String br) throws IOException {
		FileReader file = new FileReader("C:\\Users\\2303838\\eclipse-workspace-selenium\\CASProject\\CASProject\\src\\test\\resources\\config.properties");
		p= new Properties();
		p.load(file);
		 logger=LogManager.getLogger(this.getClass());
		if(br.equals("Chrome")) {
			driver = new ChromeDriver();
}		else if(br.equals("edge")) {
			driver = new EdgeDriver();	
}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://be.cognizant.com");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void teardown() {
		logger.info("All Tests have passed.");
		//driver.close();
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}

}
