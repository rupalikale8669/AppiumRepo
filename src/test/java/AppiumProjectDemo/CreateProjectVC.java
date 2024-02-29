package AppiumProjectDemo;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.AppiumBy.*;

public class CreateProjectVC extends VCIOSBaseTest{

    @Test
    public void createNewProject_VC() throws InterruptedException {
        /*ScreenOrientation curr = driver.getOrientation();
        System.out.println(curr);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(5000);*/

        //SIGN-IN
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"SIGN IN WITH SSO\"]")).click();

        //****CREATE NEW PROJECT
        System.out.println("TC_003_User click on 'CREATE NEW PROJECT Option");
        String btnName=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"  CREATE NEW PROJECT\"`]")).getText();
        Assert.assertEquals(btnName,"  CREATE NEW PROJECT","Button name is displayed as expected");

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"  CREATE NEW PROJECT\"]")).click();
        //validate user redirected to 'Product search' page or not
        String pageTitle=driver.findElement(accessibilityId("Product Search")).getText();
        Assert.assertEquals(pageTitle,"Product Search","user is on product search page");

        //****Click on the dropdown element
        System.out.println("TC_004_User click on 'Sort By' option and Select 'Price High to Low' from list");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Sort By: Designer Recommends  \"]")).click();
        //****Select option from dropdown
        driver.findElement(accessibilityId("Price High to Low")).click();

        //****Add to project functionality
        System.out.println("TC_005_User select product and click on 'ADD TO PROJECT' button");
        driver.findElement(accessibilityId("Fett Wall Sconce")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"  ADD TO PROJECT\"]")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\" BACK TO PROJECT EDITOR\"]")).click();
        //****using iOS CLASS Chain
        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \" BACK TO PROJECT EDITOR\"`]")).click();

        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR and Edit product details");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Comment \"`][1]")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[3]/XCUIElementTypeOther")).sendKeys("Test");
        driver.findElement(accessibilityId("addquantity")).click();

        //Add customer details
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"VCShowroomApp_STAGE\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther")).sendKeys("Test@gmail.com");




    }


}
