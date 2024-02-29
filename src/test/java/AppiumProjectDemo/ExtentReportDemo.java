package AppiumProjectDemo;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Date;

public class ExtentReportDemo {
     ExtentHtmlReporter htmlReporter;
     ExtentReports extent;


    @BeforeSuite
    public void reportSetup(){
        // start reporters
        Date date= new Date();
        htmlReporter = new ExtentHtmlReporter("QA_Reports_"+date+".html");
        htmlReporter.config().setReportName("Web Automation Results");
        htmlReporter.config().setDocumentTitle("Test Results");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester","Rupali K");
        extent.flush();
    }

    @AfterSuite
    public void reportTearDown(){
        // calling flush writes everything to the log file
        extent.flush();
    }
}
