package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity4 {
	
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
        Thread.sleep(1000);
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
    
    String pageTitle = driver.getTitle();
	System.out.println(pageTitle);
   
   }
    
    @AfterMethod
    public void afterMethod() {
    	driver.close();
    }

}









