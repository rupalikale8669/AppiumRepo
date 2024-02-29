package AppiumProjectDemo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class VCBasicsRun extends VCIOSBaseTest {
    CreateProjectVC createProject;

    @Test
    public void VCIOSBasicsRun() throws InterruptedException {
        //****Login functionality
        System.out.println("TC_001_User click on Sign-in link");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"SIGN IN WITH SSO\"]")).click();


        //****search functionality****
        System.out.println("TC_002_User enter text in search box and validate message if product is not found");
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeTextField[@value=\"Search By Document ID, Email, Customer Name, Project Name\"]"));
        element.sendKeys("TABLE");
        driver.findElement(AppiumBy.accessibilityId("iconSearch")).click();
        String msg = driver.findElement(accessibilityId("We're sorry, but there are no results that match your search criteria")).getAttribute("name");
        Assert.assertEquals(msg, "We're sorry, but there are no results that match your search criteria");


    }
}
