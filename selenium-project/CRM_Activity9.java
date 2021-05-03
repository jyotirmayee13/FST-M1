package TestNGActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CRM_Activity9 {
	
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
    }
    
    @Test
    public void loginTest() throws InterruptedException {
    WebElement username = driver.findElement(By.id("user_name"));
    WebElement password = driver.findElement(By.id("username_password"));
 
    username.sendKeys("admin");
    password.sendKeys("pa"+"\u0024"+"\u0024"+"w0rd");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='Login']")).click();
    Thread.sleep(5000);
    
    WebElement salesmenu = driver.findElement(By.id("grouptab_0"));
    salesmenu.click();
    WebElement leadsmenu = driver.findElement(By.id("moduleTab_9_Leads"));
    leadsmenu.click();
    Thread.sleep(5000);
    
    List<WebElement> table=driver.findElements(By.xpath("(//table/tbody)[4]"));
    for ( WebElement name : table){
    for(int i = 0;i<=10;i++)
    {
    System.out.println(driver.findElement(By.xpath("(//table/tbody)[4]/tr/td[3]")).getText()); 
    System.out.println(driver.findElement(By.xpath("(//table/tbody)[4]/tr/td[8]")).getText());
    }
   }
    
    
 }

   @AfterMethod
   public void afterMethod() {
    	driver.close();
    }

}
