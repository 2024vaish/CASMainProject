package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{
	//WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	By click_Profile_icon=By.id("meInitialsButton");
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
	
	WebElement element1=driver.findElement(By.xpath("//*[@id='getting-social']"));
	
	public Map<String,String> functionality(){
		WebElement btn=driver.findElement(click_Profile_icon);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		js.executeScript ("arguments[0].click()",btn);
		name = driver.findElement(click_name).getText();
		email = driver.findElement(click_email).getText();
		Map<String,String> mp=new HashMap<String,String>();
		mp.put(name,email);
		js.executeScript ("arguments[0].click()",btn);
		System.out.println(name+"**********"+email);
		return mp;
	}
	
	public boolean checkTextPresence()
	{
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	public void scroll() {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", untill);
	}
	public int headerVisible() {
		int count=newsLinks.size();
	    return count;
	     
	}
	public String headerText() {
		String text = null;
		for(int i=0;i<newsLinks.size();i++) {
	    	 WebElement element=newsLinks.get(i);
	    	 text = element.getText();
	    	 }
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
		   js.executeScript("arguments[0].scrollIntoView();", seeAllLink);
		   Thread.sleep(2000);	          
        seeAllLink.click();
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
	
}
