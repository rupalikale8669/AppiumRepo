package AppiumProjectDemo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSBaseTest {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
     @BeforeClass
    public void ConfigurationAppium() throws MalformedURLException {
         //start appium server
         service=new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
         service.start();
         //set capabilities
         XCUITestOptions options=new XCUITestOptions();
         options.setDeviceName("iPhone 15 Pro Max");
         //options.setDeviceName("iPhone 15");
         //options.setDeviceName("KCS-Pune");
         //options.setDeviceName("My Mac(Mac Catalyst)");
         options.setApp("/Users/qa/Library/Developer/Xcode/DerivedData/UIKitCatalog-ejdrayzrqvuathbwfqsgmjmfiqcr/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
         //options.setApp("/Users/qa/Desktop/VCShowroomApp_Stage_14EndSprint_0_14_4\\ \\(1\\).ipa");
         options.setPlatformVersion("17.2");
         options.setWdaLaunchTimeout(Duration.ofSeconds(20));

         //Initialise iOS driver
         driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
     @AfterClass
    public void tearDown(){
         driver.quit();
         service.stop();
     }
}
