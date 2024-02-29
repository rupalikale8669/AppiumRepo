package AppiumProjectDemo;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class VCTestCasesParameterizationJSON extends VCIOSBaseTest {
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"//src//test//java//AppiumProjectDemo//testData//vcTestData.json");
        return new Object[][] { {data.get(0)} };
    }


    @Test(priority = 0)
    public void clickOnSignIn() throws InterruptedException {
        //****Login functionality
        System.out.println("TC_001_User click on Sign-in link");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"SIGN IN WITH SSO\"]")).click();
    }

    @Test(priority = 1)
    public void searchProduct() {
        System.out.println("TC_002_User enter text in search box and validate message if product is not found");
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeTextField[@value=\"Search By Document ID, Email, Customer Name, Project Name\"]"));
        element.sendKeys("TABLE");

        driver.findElement(AppiumBy.accessibilityId("iconSearch")).click();
        String actualmsg = driver.findElement(accessibilityId("We're sorry, but there are no results that match your search criteria")).getAttribute("name");
        String expmsg = "We're sorry, but there are no results that match your search criteri";
        Assert.assertEquals(actualmsg,expmsg,"Message displayed as expected");
    }
    @Test(priority = 1)
    public void validateFilterFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(accessibilityId("View Projects")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Clear All\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Filter By  \"`]")).click();
        WebElement dateElement=driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Date\"]"));

        TouchAction action=new TouchAction(driver);
        action.tap(tapOptions().withElement(element(dateElement))).perform();

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Last 7 Days\"`]")).click();

        WebElement status=driver.findElement(accessibilityId("Status"));
        action.tap(tapOptions().withElement(element(status))).perform();

        Thread.sleep(1000);

        //driver.findElement(accessibilityId("New")).click();
        driver.findElement(accessibilityId("Open")).click();

        WebElement showroom=driver.findElement(accessibilityId("Showroom"));
        action.tap(tapOptions().withElement(element(showroom))).perform();

        //search showroom
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Search By Showroom\"`]")).sendKeys("Atlanta Showroom");
        Thread.sleep(1000);

    }

    @Test(priority = 2)
    public void createNewProject() {
        //****CREATE NEW PROJECT
        System.out.println("TC_003_User click on 'CREATE NEW PROJECT Option");
        String btnName = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"  CREATE NEW PROJECT\"`]")).getText();
        Assert.assertEquals(btnName, "  CREATE NEW PROJECT", "Button name is displayed as expected");
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"  CREATE NEW PROJECT\"]")).click();
        String pageTitle = driver.findElement(accessibilityId("Product Search")).getText();
        Assert.assertEquals(pageTitle, "Product Search", "user is on product search page");

    }

    @Test(priority = 3)
    public void selectValueFromDropdown() {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Sort By: Designer Recommends  \"]")).click();
        //****Select option from dropdown
        driver.findElement(accessibilityId("Price High to Low")).click();

    }

    @Test(priority = 4)
    public void verifyAddToProject() {
        System.out.println("TC_005_User select product and click on 'ADD TO PROJECT' button");
        driver.findElement(accessibilityId("Falaise Grande Two Tier Chandelier")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"  ADD TO PROJECT\"]")).click();
    }

    @Test(priority = 5)
    public void clickOnNavigateBackToProjectEditor() {
        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \" BACK TO PROJECT EDITOR\"`]")).click();
    }

    @Test(priority = 6)
    public void validateEditProjectDetails() {
        System.out.println("TC_006_User Navigated BACK TO PROJECT EDITOR and Edit product details");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Comment \"`][1]")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[3]/XCUIElementTypeOther")).sendKeys("Test");
        driver.findElement(accessibilityId("addquantity")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONTINUE TO CUSTOMER DETAILS\"`]")).click();
    }
    //real device
    @Test(dataProvider = "getData",priority = 7)
    public void createCustomerDetailsRD(HashMap<String,String> input) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")).sendKeys(input.get("ProjectEmail"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField")).sendKeys(input.get("PhoneNumber"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")).sendKeys(input.get("CompanyName"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField")).sendKeys(input.get("Name"));
        Thread.sleep(1000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[11]/XCUIElementTypeTextField")).sendKeys(input.get("AddressLine"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[12]/XCUIElementTypeTextField")).sendKeys(input.get("AddressLine2"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[15]/XCUIElementTypeTextField")).sendKeys(input.get("City"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[16]/XCUIElementTypeTextField")).sendKeys(input.get("StateProvinces"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[19]/XCUIElementTypeTextField")).sendKeys(input.get("ZipPostalCode"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[20]/XCUIElementTypeTextField")).sendKeys(input.get("Country"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"  Use same address for billing\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"CONTINUE\"`]")).click();
    }

    @Test(dataProvider = "getData",priority = 7)
    public void addCustomerDetails(HashMap<String,String> input) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")).sendKeys(input.get("ProjectEmail"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField")).sendKeys(input.get("PhoneNumber"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")).sendKeys(input.get("CompanyName"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField")).sendKeys(input.get("Name"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[11]/XCUIElementTypeTextField")).sendKeys(input.get("AddressLine"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[12]/XCUIElementTypeTextField")).sendKeys(input.get("AddressLine2"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[15]/XCUIElementTypeTextField")).sendKeys(input.get("City"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[16]/XCUIElementTypeTextField")).sendKeys(input.get("StateProvinces"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[19]/XCUIElementTypeTextField")).sendKeys(input.get("ZipPostalCode"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[20]/XCUIElementTypeTextField")).sendKeys(input.get("Country"));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"  Use same address for billing\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"CONTINUE\"`]")).click();
    }
    @Test(priority = 8)
    public void viewEditProjectDetails(){
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"VIEW/EDIT PROJECT DETAILS \"`]")).click();
        driver.findElement(accessibilityId("Darshini | CASTEST")).click();
        driver.findElement(accessibilityId("requiredByCalendar")).click();
        driver.findElement(accessibilityId("Appointment")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys("project note");
        driver.findElement(accessibilityId("closeCustomerList")).click();
    }
    @Test(priority = 9)
    public void validateQuoteSummary() throws InterruptedException {
        String productStatus=driver.findElement(accessibilityId("Status: NEW")).getText();
        Assert.assertEquals(productStatus,"Status: NEW");
        String customerDetailsTxt=driver.findElement(accessibilityId("Customer Details")).getText();
        Assert.assertEquals(customerDetailsTxt,"Customer Details");
        String customerName=driver.findElement(accessibilityId("Customer Name")).getText();
        Assert.assertEquals(customerName,"Customer Name");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"  EMAIL\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Enter Email\"`]")).sendKeys("testing@gmail.com");
        Thread.sleep(2000);
        driver.findElement(accessibilityId("Email Project")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"SEND\"`]")).click();
    }

}
