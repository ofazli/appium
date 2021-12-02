package Appium;

import com.sun.tools.javac.comp.Enter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06Chrome {
    @Test

    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //chrome driver yoksa
        //desiredCapabilities.setCapability("chromedriverExecutable", "/Users/orcunfazli/Downloads/mobileTest/driver/chromedriver");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.get("https://www.amazon.com");
        driver.findElementByXPath("//*[@id=\"nav-logobar-greeting\"]").click();
        String actuaTitle = driver.findElementByXPath("//*[@id=\"outer-accordion-signin-signup-page\"]/h2").getText();
        Thread.sleep(2000);
        String extual = "Welcome";
        Thread.sleep(1000);
        Assert.assertEquals(actuaTitle,extual);

        Set contextNames = driver.getContextHandles();
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
            Thread.sleep(3000);
            if (contextName.toString().contains("CHROMIUM")){
                driver.context((String) contextName);//WEBAPP DEVAM EDECEGIM
                Thread.sleep(10000);
            }
        }


        driver.closeApp();


    }

}
