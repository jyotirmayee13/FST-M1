package project;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity_4 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
  @Test
  public void todoList() throws InterruptedException {
      driver.get("https://www.training-support.net/selenium");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      MobileElement title = driver.findElementByXPath("//android.view.View[2][@text='Selenium']");
      String pageTitle = title.getText();
      System.out.println("The page Title is: " + pageTitle);
      Assert.assertEquals(pageTitle, "Selenium");
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
      driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      //To-Do List page
      MobileElement todoTitle = driver.findElementByXPath("//android.view.View[2][@text='To-Do List']");
      String todoListTitle = todoTitle.getText();
      System.out.println("The page Title is: " +todoListTitle);
      Assert.assertEquals(todoListTitle, "To-Do List");

      String[] tasksToAdd = {
              "Add Task 1",
              "Add Task 2"
      };

      for(String addTasks: tasksToAdd) {
          driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
          driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(addTasks);
          driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      }

      driver.findElementByXPath("//android.view.View[@text='Add Task 1']").click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElementByXPath("//android.view.View[@text='Add Task 2']").click();

      MobileElement clearListBtn = driver.findElementByXPath("//android.view.View[3][@class='android.view.View']");
      clearListBtn.click();
  }
  @AfterTest 
  public void closeDriver() {
      driver.quit();
  }
}
