package project;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity_2 {
    
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
            }
  @Test
  
  public void addNote() {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      
      Actions action = new Actions(driver);
      
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
      MobileElement addNoteBtn = driver.findElementByAccessibilityId("New text note");
      addNoteBtn.click();
      
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_note_interior_content")));
      MobileElement addTitle = driver.findElementById("browse_note_interior_content");
      addTitle.click();
      action.sendKeys(" Appium Avtivity 2").perform();
      
      MobileElement addDescNote = driver.findElementById("edit_note_text");
      addDescNote.click();
      action.sendKeys(" Completed Appium Avtivity 2").perform();
      
      MobileElement backBtn = driver.findElementByAccessibilityId("Open navigation drawer");
      backBtn.click();
      
      MobileElement addedNote = driver.findElementById("browse_text_note");
      Assert.assertTrue(addedNote.isDisplayed());
      
  }
  @AfterClass 
    public void closeDriver() {
        driver.quit();
    }
}
