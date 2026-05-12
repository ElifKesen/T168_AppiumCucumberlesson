package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYuklemeStepDef {
    AndroidDriver<AndroidElement>androidDriver;

    @Given("Kullanici {string} dosyayolu verilen APkyi yukler")
    public void kullanici_dosyayolu_verilen_a_pkyi_yukler(String apkDosyaYolu) throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 H");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP,apkDosyaYolu);

        androidDriver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
}
