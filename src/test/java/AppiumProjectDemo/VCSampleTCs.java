package AppiumProjectDemo;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class VCSampleTCs extends VCIOSBaseTest {



    @Test(priority = 0)
    public void clickOnSignIn() throws InterruptedException {
        //****Login functionality
        ExtentTest test1 = extent.createTest("TC_001", "Login to the application");
        System.out.println("TC_001_User click on Sign-in link");
        test1.log(Status.INFO, "Application started");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"SIGN IN WITH SSO\"]")).click();
        test1.log(Status.PASS, "Clicked on Sign-In link");
    }

    @Test(priority = 1)
    public void searchProduct() {
        ExtentTest test2 = extent.createTest("TC_002", "Search product in searchbox");
        System.out.println("TC_002_User enter text in search box and validate message if product is not found");
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeTextField[@value=\"Search By Document ID, Email, Customer Name, Project Name\"]"));
        element.sendKeys("TABLE");
        test2.log(Status.PASS, "Enter product name in product searchbox");

        driver.findElement(AppiumBy.accessibilityId("iconSearch")).click();
        String actualmsg = driver.findElement(accessibilityId("We're sorry, but there are no results that match your search criteria")).getAttribute("name");
        String expmsg = "We're sorry, but there are no results that match your search criteria";

        //test2.log(Status.INFO, "Validate information message..");
        if (!actualmsg.equals(expmsg)) {
            test2.log(Status.FAIL, "Error message is not showing as expected");
        } else {
            test2.log(Status.INFO, "Validate information message..");
        }
    }

    @Test(priority = 2)
    public void createNewProject() {
        //****CREATE NEW PROJECT
        ExtentTest test3 = extent.createTest("TC_003", "Create new Project");
        System.out.println("TC_003_User click on 'CREATE NEW PROJECT Option");
        String btnName = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"  CREATE NEW PROJECT\"`]")).getText();
        Assert.assertEquals(btnName, "  CREATE NEW PROJECT", "Button name is displayed as expected");

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"  CREATE NEW PROJECT\"]")).click();
        test3.log(Status.PASS, "User click on 'CREATE NEW PROJECT Option");

        String pageTitle = driver.findElement(accessibilityId("Product Search")).getText();
        Assert.assertEquals(pageTitle, "Product Search", "user is on product search page");
        test3.log(Status.PASS, "validate user redirected to 'Product search' page or not ");
    }

    @Test(priority = 3)
    public void selectValueFromDropdown() throws InterruptedException {
        ExtentTest test4 = extent.createTest("TC_004", "User click on 'Sort By' option and Select 'Price High to Low' from list");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Sort By: Designer Recommends  \"]")).click();
        //****Select option from dropdown
        driver.findElement(accessibilityId("Price High to Low")).click();
        test4.log(Status.PASS, "clicked on 'Sort by' dropdown");
    }

    @Test(priority = 4)
    public void verifyAddToProject() throws InterruptedException {
        ExtentTest test5 = extent.createTest("TC_005", "Verify Add to project button functionality");
        System.out.println("TC_005_User select product and click on 'ADD TO PROJECT' button");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Filter By  \"`]")).click();
        driver.findElement(accessibilityId("Falaise Grande Two Tier Chandelier")).click();
        Thread.sleep(1000);
        test5.log(Status.PASS, "User selected product to add");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"  ADD TO PROJECT\"]")).click();
        test5.log(Status.PASS, "click on 'ADD TO PROJECT' button");
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\" BACK TO PROJECT EDITOR\"]")).click();
    }

    @Test(priority = 5)
    public void clickOnNavigateBackToProjectEditor() {
        ExtentTest test6 = extent.createTest("TC_006", "User Navigated BACK TO PROJECT EDITOR");
        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \" BACK TO PROJECT EDITOR\"`]")).click();
        test6.log(Status.PASS, "Click on Back to project editor link");
    }

    @Test(priority = 6)
    public void validateEditProjectDetails() {
        ExtentTest test7 = extent.createTest("TC_007", "Edit product details");
        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR and Edit product details");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Comment \"`][1]")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[3]/XCUIElementTypeOther")).sendKeys("Test");
        driver.findElement(accessibilityId("addquantity")).click();
        test7.log(Status.PASS, "click on add icon");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
        test7.log(Status.PASS, "click on 'Continue to Customer Detail' button");
    }

    @Test(priority = 7)
    public void addCustomerDetails() throws InterruptedException {
        ExtentTest test8 = extent.createTest("TC_008", "Add Customer Details");
        test8.log(Status.INFO,"User Entering details");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")).sendKeys("rupali.kale@rysun.com");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField")).sendKeys("987456321");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")).sendKeys("Test1");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField")).sendKeys("rupali");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[11]/XCUIElementTypeTextField")).sendKeys("2934 Delaware Avenue");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[12]/XCUIElementTypeTextField")).sendKeys("California");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[15]/XCUIElementTypeTextField")).sendKeys("Sausalito");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[16]/XCUIElementTypeTextField")).sendKeys("California");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[19]/XCUIElementTypeTextField")).sendKeys("94965");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[20]/XCUIElementTypeTextField")).sendKeys("United States");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"CONTINUE\"`]")).click();
        test8.log(Status.PASS,"Click on Continue button");
    }
    @Test(priority = 8)
    public void validateQuoteSummary() throws InterruptedException {
        ExtentTest test9 = extent.createTest("TC_009", "Validate Quote Summary details");
        String productStatus=driver.findElement(accessibilityId("Status: NEW")).getText();
        Assert.assertEquals(productStatus,"Status: NEW");
        test9.log(Status.PASS,"Project status is displayed as 'NEW'");
        String customerDetailsTxt=driver.findElement(accessibilityId("Customer Details")).getText();
        Assert.assertEquals(customerDetailsTxt,"Customer Details");
        String customerName=driver.findElement(accessibilityId("Customer Name")).getText();
        Assert.assertEquals(customerName,"Customer Name");
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"SEND TO QUOTE\"`]")).click();
        //test9.log(Status.PASS,"User click on 'Send Quote' button");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"  EMAIL\"`]")).click();
        test9.log(Status.PASS,"User clicked on Email button");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Enter Email\"`]")).sendKeys("rupali.kale@rysun.com");
        test9.log(Status.PASS,"Enter Guest mail ID");
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTextView\"")).sendKeys("Testing");
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[9]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeTextView")).sendKeys("Testing Automation !!!");
        Thread.sleep(2000);
        driver.findElement(accessibilityId("Email Project")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"SEND\"`]")).click();
        test9.log(Status.PASS,"User click on Send button");
        test9.log(Status.INFO,"Email sent successfully.!!!");
    }

    @Test(priority = 9)
    public void createCustomerDetails() {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \" BACK TO HOMEPAGE\"`]")).click();
        // driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"EDIT PROJECT\"`][1]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"addquantity\"`][1]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"VCShowroomApp_STAGE\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]")).sendKeys("Test");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField")).sendKeys("Rupali");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[11]/XCUIElementTypeTextField")).sendKeys("US");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[15]/XCUIElementTypeTextField")).sendKeys("Alley");
        //driver.findElement(accessibilityId("Name*")).sendKeys("Rupali");
        //driver.findElement(accessibilityId("Address Line")).sendKeys("US");
    }

    @Test(priority = 10)
    public void checkFilterFunctionalityInProductSearchTab() throws InterruptedException {
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"VCShowroomApp_STAGE\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther")).sendKeys("Test@gmail.com");
        ExtentTest test10 = extent.createTest("TC_008", "Apply filter in Product search tab");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \" BACK TO HOMEPAGE\"`]")).click();
        test10.log(Status.INFO, "User Navigated to Home page");
        driver.findElement(accessibilityId("View Projects")).click();
        test10.log(Status.PASS, "click on view project option");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Filter By  \"`]")).click();
        test10.log(Status.PASS, "click on Filter option");
        //SWITCH TO Frame
        Thread.sleep(3000);
        //driver.switchTo().activeElement();
        String str = driver.findElement(accessibilityId("Filter By")).getText();
        System.out.println(str);
        String buttonText = driver.findElement(accessibilityId("Date")).getText();
        System.out.println(buttonText);
        Thread.sleep(5000);
        driver.findElement(accessibilityId("Date")).click();
        //Touch Action Class
        //WebElement element=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Date\"`]"));
        //TouchAction action1 = new TouchAction(driver);


        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Date\"`]")).click();
        test10.log(Status.PASS, "user select 'Date' filter option");
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Today\"`]")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Today\" AND label == \"Today\" AND value == \"Today\"")).click();
        test10.log(Status.PASS, "Select date option as 'Today'");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Status\"`]")).click();
        test10.log(Status.PASS, "user select 'Status' filter option");
    }


}
