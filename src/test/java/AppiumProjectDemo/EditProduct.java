package AppiumProjectDemo;

import io.appium.java_client.AppiumBy;

public class EditProduct extends VCIOSBaseTest {


    public void validateEditProductFunctionality(){
    String totalItem= driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Total Items'")).getText();
    System.out.println(totalItem);
    }
}
