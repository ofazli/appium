package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/*
    lunch GestureTool app
    click addGesture button
    send text to name box "testing"
    click done
    verify testing gesture is created
 */
public class Appium04 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,  "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/orcunfazli/Downloads/mobileTest/Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>( new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(4000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("testing");
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        String actualText = driver.findElementByXPath("//android.widget.TextView[2]").getText();
        String extualText = "testing";
        Assert.assertEquals(actualText,extualText);



    }
}
