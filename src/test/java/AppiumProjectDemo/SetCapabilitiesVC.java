package AppiumProjectDemo;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.*;

public class SetCapabilitiesVC {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    DesiredCapabilities cap;
    @BeforeClass
    public void setCap() throws MalformedURLException {
        service=new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        cap=new DesiredCapabilities();
        cap.setCapability("platformName","iOS");
        cap.setCapability("udid","acb85f7f0a4a6527c414bcacf4607a048d4d548f");
        cap.setCapability("app","/Users/qa/Downloads/VCShowroomApp_Stage.ipa");
        cap.setCapability("automationName","XCUITest");
        cap.setCapability("deviceName","ANKIT’s iPad");
        cap.setCapability("platformVersion","17.3.1");

        URL url=new URL("http://127.0.0.1:4723");
        driver=new IOSDriver(url,cap);
        //driver=new IOSDriver(new URL("http://127.0.0.1:4723"),cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @AfterClass
    public void tearDownFun(){
        service.stop();
    }
}
