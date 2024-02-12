package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	//WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	By click_Profile_icon=By.id("O365_MainLink_Me");//mectrl_main_trigger
	By click_name=By.id("mectrl_currentAccount_primary");
	By click_email = By.id("mectrl_currentAccount_secondary");
	String name;
	String email;
	
	@FindBy(how=How.XPATH, using="//span[@class=\"fontSizeXLarge\"]/strong")
	WebElement AroundCognizant;
	
	@FindBy(how=How.XPATH, using="//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']")
	public List<WebElement> newsLinks;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"6a300658-3c93-45bc-8746-5964a4379bbf\"]")
	WebElement untill;
	
	@FindBy(xpath="//a//strong[text()='See all']")
	WebElement seeAllLink;//=driver.findElement(By.xpath("//a//strong[text()='See all']"));
	
	@FindBy(id="O365_MainLink_Me")
	WebElement btn;//=driver.findElement(click_Profile_icon);
	
	List<String> text = new ArrayList<String>();
	
	public void getNewsLinks() {
		newsLinks=driver.findElements(By.xpath("//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));
		
	}
	public void scroll(WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}
 	
	 public void hoverOverElement(WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		 
	 }
	
	public void clickProfileIcon() {
		hoverOverElement(btn);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(click_Profile_icon));
		js.executeScript ("arguments[0].click()",btn);
	}
	
	public List<String> getUserDetails() {
		name = driver.findElement(click_name).getText();
		email = driver.findElement(click_email).getText();
		List<String> details=new ArrayList<String>();
		details.add(name);
		details.add(email);
		System.out.println(name+"**********"+email);
		return details;
	}
	
	public boolean checkTextPresence()
	{
		scroll(AroundCognizant);
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	
	public int headerVisible() {
		int count=newsLinks.size();	
		
	    return count;
	    
	     
	}

	public List<String> headerText() {
		this.getNewsLinks();
		System.out.println("Home Page NewsLinks Count :"+newsLinks.size());
		for(WebElement ele:newsLinks) {
			text.add(ele.getText());
		}
		System.out.println("Home Page News Count :"+text.size());
		return text; 
	}
	
	
	public boolean tooltip() {
	
		String headertext;
		boolean flag=false;
		for(int i=0;i<newsLinks.size();i++) {
		WebElement link=newsLinks.get(i);
		headertext=link.getText();
		String tooltipText=link.getAttribute("title");
		flag=tooltipText.equals(headertext);
		if(flag==false)
			break;
		}
		return flag;
	}

	 public void clickSeeAllLink(){
		scroll(seeAllLink);
		js.executeScript("arguments[0].scrollIntoView();", seeAllLink);
		hoverOverElement(seeAllLink);
		seeAllLink.click();
 		
		
}


	
	
/*

	public void sample() throws InterruptedException {
		List<WebElement> el=driver.findElements(By.xpath("//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));
		   String[] data=new String[6];
		   int i=0;
		   for(WebElement e:el) {
			   data[i]=e.getText();
			   i++;
			   System.out.println(e.getText());
		   }
		 //  WebElement element=driver.findElement(By.xpath("//*[@class=\"fontSizeMedium\"]/strong"));
		  
		   Thread.sleep(2000);	          
       // seeAllLink.click();
        Thread.sleep(5000);	       
        List<WebElement> list2=driver.findElements(By.xpath("//a[starts-with(@class,'k_a_91bed31b text_title')]"));
        String[] data1=new String[8];
        int i1=0;
        System.out.println(list2.size());
        for(WebElement e : list2) {
     	   js.executeScript("arguments[0].scrollIntoView();",e);
     	   data1[i1]=e.getText();
     	   i1++;
     	   Thread.sleep(2000);
     	   System.out.println(e.getText());
   }
        try {
        for(int i2=0;i2<=7;i2++) {
     	   if(data1[i2].equalsIgnoreCase(data[i2])) {
     		   System.out.println("pass");
     	   }
     	   else {
     		   System.out.println("fail");
     	   }
        }
        }
        catch(ArrayIndexOutOfBoundsException e) {
     	   
        }
	}
	public void clickLink() {
		String a=seeAllLink.getText();
		
		seeAllLink.click();
		System.out.println(a);
	}
	*/
}
