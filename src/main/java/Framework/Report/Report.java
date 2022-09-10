package Framework.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

public class Report {
    private static final ExtentReports extentReports = ReportFactory.getInstance();

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();


    public static void createReportTest(String testName, ReportType type){
        if(type.equals(ReportType.SINGLE)){
            ExtentTest extentTest = extentReports.createTest(testName);
            test.set(extentTest);
            return;
        }
        ExtentTest extentTest = extentReports.createTest(testName);
        parentTest.set(extentTest);
    }

    public static void createStep(String stepName){
        try{
            ExtentTest step = parentTest.get().createNode(stepName);
            test.set(step);
        }catch (NullPointerException error){

        }
    }

    private static boolean existInstance(){
        if (test.get()==null){
            return true;
        }
        return false;
    }

    public static void closeReport(){
        if(existInstance()){
            return;
        }
        extentReports.flush();
    }

    public static void logWithCapture(Status status, String message, Media capture){
        if(existInstance()){
            return;
        }
        test.get().log(status, message, capture);
    }

    public static void logWithNoCapture(Status status, String message){
        if(existInstance()){
            return;
        }
        test.get().log(status, message);
    }

}
