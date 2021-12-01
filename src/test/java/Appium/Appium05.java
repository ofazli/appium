package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {
    @Test

    public void test() throws MalformedURLException, InterruptedException {
        /*

          install app
          do any mathematical operation
          and verify pre result and final result

         */
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/orcunfazli/Downloads/mobileTest/Apps/Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        AndroidElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        AndroidElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        AndroidElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        AndroidElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        AndroidElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        AndroidElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        AndroidElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        AndroidElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        AndroidElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        AndroidElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        AndroidElement del = driver.findElementById("com.google.android.calculator:id/del");
        AndroidElement des = driver.findElementById("com.google.android.calculator:id/op_div");
        AndroidElement mul = driver.findElementById("com.google.android.calculator:id/op_mul");
        AndroidElement sub = driver.findElementById("com.google.android.calculator:id/op_sub");
        AndroidElement dd = driver.findElementById("com.google.android.calculator:id/op_add");
        AndroidElement equ = driver.findElementById("com.google.android.calculator:id/eq");

        num1.click();
        num5.click();
        mul.click();
        num3.click();
        Thread.sleep(1500);
        String actual = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(actual, "45");

        Thread.sleep(3000);

        equ.click();
        driver.closeApp();


    }

}


