package TestNGActivities;

import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CRM_Activity8 {
	
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
    WebElement accountssmenu = driver.findElement(By.id("moduleTab_9_Accounts"));
    accountssmenu.click();

    //Get rows
    List<WebElement> rows = driver.findElements(By.xpath("(//table/tbody)[4]/tr[@class='oddListRowS1']")); 
    System.out.println("Number of rows are: " + rows.size());
    Actions builder = new Actions(driver);
    builder.keyDown(Keys.CONTROL)
           .click(rows.get(0))
           .click(rows.get(1))
           .click(rows.get(2))
           .click(rows.get(3))
           .click(rows.get(4))
           .keyUp(Keys.CONTROL).build().perform();
  
    System.out.println(rows.get(0).getText());
    System.out.println(rows.get(1).getText());
    System.out.println(rows.get(2).getText());
    System.out.println(rows.get(3).getText());
    System.out.println(rows.get(4).getText());
    }
    
    @AfterMethod
    public void afterMethod() {
    	driver.close();
    }

}
