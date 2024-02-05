package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//a//strong[text()='See all']")
	WebElement seeAllLink;//=driver.findElement(By.xpath("//a//strong[text()='See all']"));
	
	public void clickLink() {
		String a=seeAllLink.getText();
		
		seeAllLink.click();
		System.out.println(a);
	}
	
}
