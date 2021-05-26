package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity_1 {

    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addNewTask() {
    String[] tasksToAdd = { "Complete Activity with Google Tasks", "Complete Activity with Google Keep",
              "Complete the second Activity Google Keep" };
//         Object tasksToAdd;
    for(String taskToAdd: tasksToAdd) {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title"))); 
        driver.findElementById("add_task_title").sendKeys(taskToAdd);
        driver.findElementById("add_task_done").click();
        }

        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"), 3));
        List<MobileElement> tasksadded = driver.findElementsById("add_task_title");
        assertEquals(tasksadded.size(), 3);
        assertEquals(tasksadded.get(2).getText(), "Complete the second Activity Google Keep");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
