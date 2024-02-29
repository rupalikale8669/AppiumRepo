package AppiumProjectDemo;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class AppiumUtils {
        //Touch actions in appium
        /*TouchAction action=new TouchAction(driver);
        action.tap(tapOptions().withElement(element(dateElement))).perform();*/

    public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {
        File source=driver.getScreenshotAs(OutputType.FILE);
        String destinationFile="//Users//qa//IdeaProjects//AppiumAutomation//target//reports"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }


}
