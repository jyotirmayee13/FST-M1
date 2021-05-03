package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity3 {
	
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void exampleTestCase() {
     	
    	WebElement copyrighttext = driver.findElement(By.id("admin_options"));
        System.out.println("First copyright test is: "+ copyrighttext.getText());


    }

    @AfterMethod
    public void afterMethod() {
         driver.quit();
    }

}
