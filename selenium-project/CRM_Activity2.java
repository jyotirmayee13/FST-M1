package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity2 {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void exampleTestCase() {
     	
    	WebElement suitecrm = driver.findElement(By.xpath("//*[contains(@src,'company_logo')]"));
    	 System.out.println("Src attribute is: "+ suitecrm.getAttribute("src"));

    }

    @AfterMethod
    public void afterMethod() {
         driver.quit();
    }

}



		
	