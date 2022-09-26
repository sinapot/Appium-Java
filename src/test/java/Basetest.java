import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

//this base test will take any number of devices specified in wdio xml file
public class Basetest {
    ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public void setDriver(AppiumDriver driver){
        this.driver.set(driver);
    }
    public AppiumDriver getDriver(){
        return this.driver.get();
    }
    @BeforeClass
    @Parameters({"deviceName","platformVersion","platformName","automationName",
                 "udid",      "systemPort",     "wdaLocalPort"})

    public void ios_setUp(String deviceName,     String platformVersion, String platformName,
                          String automationName, String udid,
                          @Optional("androidOnly") String systemPort,
                          @Optional("iosOnly") String wdaLocalPort)
                          throws MalformedURLException {


        if (platformName.equals("iOS"))
        {
            XCUITestOptions caps = new XCUITestOptions();
            caps.setCapability("appium:wdaLocalPort",       wdaLocalPort);
            caps.setCapability("appium:udid",               udid);
            caps.setCapability("appium:platformVersion",    platformVersion);
            caps.setCapability("appium:deviceName",         deviceName);
            caps.setCapability("appium:automationName",     automationName);
            caps.setCapability("platformName",              platformName);
            caps.setCapability("app",                 System.getProperty("user.dir") + "/apps/iOS-Simulator-NativeDemoApp-0.4.0.app.zip");
            URL remoteUrl = new URL("http://127.0.0.1:4723");
            setDriver(new IOSDriver(remoteUrl, caps));
        }
        else {
            UiAutomator2Options caps = new UiAutomator2Options();
            caps.setCapability("appium:systemPort",         systemPort);
            //caps.setCapability("appium:udid",               udid);
            caps.setCapability("appium:automationName",     automationName);
            caps.setCapability("appium:platformVersion",    platformVersion);
            caps.setCapability("platformName",              platformName);
            caps.setCapability("appium:deviceName",         deviceName);
            caps.setCapability("app",                 System.getProperty("user.dir")+"/apps/Android-NativeDemoApp-0.4.0.apk");
            caps.setCapability("appActivity",         ".MainActivity");
            caps.setCapability("appPackage",          "com.wdiodemoapp");
            URL remoteUrl = new URL("http://127.0.0.1:4723");
            setDriver(new AndroidDriver(remoteUrl, caps));
        }
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
    }
}
