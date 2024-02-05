package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class News {
	WebDriver driver;
	
	WebElement newsTitle=driver.findElement(By.xpath("//span[contains(text(),'News')]"));
	List<WebElement> newsList=driver.findElements(By.xpath("//*[@id='news_text_title']"));

}
