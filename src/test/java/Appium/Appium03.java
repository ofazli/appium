package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //UiAutomator2 -> android sisteminin test frameworku
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/orcunfazli/Downloads/mobileTest/Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(1000);

      //  driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
     //   driver.findElementByXPath("(//android.widget.Button)[2]").click();
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
    }
    /*
    Lunch GesturoTool app
    click test button
    verify title "Test a gesture"
    close app
     */
    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/orcunfazli/Downloads/mobileTest/Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver1 = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
        driver1.findElementById("com.davemac327.gesture.tool:id/testButton").click();
        Thread.sleep(3000);
        String actualresult = driver1.findElementById("android:id/title").getText();
        System.out.println(actualresult);
        String expectedTitle = "Test a gesture";
        Assert.assertEquals(actualresult,expectedTitle);
        driver1.quit();



    }
}


