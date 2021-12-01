package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {

        @Test
        public void test() throws MalformedURLException, InterruptedException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //UiAutomator2 -> android sisteminin test frameworku
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
//            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/orcunfazli/Downloads/mobileTest/Apps/apiDemos.apk");
            desiredCapabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
            desiredCapabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
            AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);


            Thread.sleep(4000);
        }
    }


