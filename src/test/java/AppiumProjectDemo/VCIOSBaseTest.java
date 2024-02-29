package AppiumProjectDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class VCIOSBaseTest extends ExtentReportDemo {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    DesiredCapabilities cap;

    /*@BeforeMethod
    public void rotateDevice(){
        //ScreenOrientation curr = driver.getOrientation();
        driver.rotation();
    }*/
    @BeforeClass
    public void ConfigurationAppium() throws IOException {
       //read property file
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//data.properties");
        prop.load(fis);

        String ipAddress=prop.getProperty("ipAddress");
        String port=prop.getProperty("port");
        String deviceName=prop.getProperty("iOSDeviceName");
        String deviceVersion=prop.getProperty("iOSDeviceVersion");
        String appPathSim=prop.getProperty("simulatorAppPath");

        service=new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //Launch application on real device
        /*cap=new DesiredCapabilities();
        cap.setCapability("platformName","iOS");
        cap.setCapability("udid","acb85f7f0a4a6527c414bcacf4607a048d4d548f");
        cap.setCapability("app","/Users/qa/Downloads/VCShowroomApp_Stage.ipa");
        cap.setCapability("automationName","XCUITest");
        cap.setCapability("deviceName","ANKIT’s iPad");
        cap.setCapability("platformVersion","17.3.1");

        URL url=new URL("http://127.0.0.1:4723");
        driver=new IOSDriver(url,cap);
        //driver=new IOSDriver(new URL("http://127.0.0.1:4723"),cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));*/

        //Launch application on simulator

        XCUITestOptions options=new XCUITestOptions();
        //options.setDeviceName("iPad (10th generation)");
        options.setDeviceName(deviceName);
        //options.setApp("/Users/qa/Library/Developer/Xcode/DerivedData/UIKitCatalog-ejdrayzrqvuathbwfqsgmjmfiqcr/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        //options.setApp("/Users/qa/Documents/VCApp_300124/APP File/VCShowroomApp_Stage.app");
        options.setApp(appPathSim);
        //options.setPlatformVersion("17.2");
        options.setPlatformVersion(deviceVersion);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
        service.stop();
    }
    public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {
        //convert json file content to json string
        //System.getProperty("user.dir")+"//src//test//java//AppiumProjectDemo//testData//vcTestData.json
        String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String,String>>>() {
                });
        return data;
    }

}
