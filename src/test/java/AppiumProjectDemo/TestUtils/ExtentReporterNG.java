package AppiumProjectDemo.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.Date;

public class ExtentReporterNG {
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    public static ExtentReports getReporterObject(){
        Date date= new Date();
        htmlReporter = new ExtentHtmlReporter("QA_Automation_Reports_"+date+".html");
        htmlReporter.config().setReportName("Web Automation Results");
        htmlReporter.config().setDocumentTitle("Test Results");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester","Rupali K");
        return extent;
    }
}
