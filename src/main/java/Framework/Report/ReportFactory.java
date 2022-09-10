package Framework.Report;

import Framework.Utils.CreateReportFolder;
import Framework.Utils.DateTime;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReportFactory {
    public static WebDriver driver;

    public static final String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report" + File.separator
            + "Report_" + DateTime.getReportDateTimeFormat();

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;

    public static void configReportExtent(){
        CreateReportFolder.createReportFolder(PATH_REPORT);
        extentSparkReporter = new ExtentSparkReporter(PATH_REPORT + File.separator + "Report_" + DateTime.getReportDateTimeFormat() + ".html");
        extentSparkReporter.config().setDocumentTitle("Relatório de Execução da Automação");
        extentSparkReporter.config().setReportName("Relatório de Execução de Testes");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("UTF-8");
        extentSparkReporter.config().setTimeStampFormat(" EEEE , MMMM dd, yyyy , hh:mm a '('zzz')'");
        extentSparkReporter.config().setCss(".nav-wrapper {​​ background-color: #1E317A !important; }​​ .brand-logo {​​ background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important }​​ .report-name {​​ margin-left: 80px !important }​​ .blue.darken-3 {​​ background-color: #1E317A !important; color: #FFF !important;}​​");
        extentSparkReporter.config().setJs("$('.brand-logo').html('<img src=\"https://i.imgur.com/qDYwkD2.png\" class=\"db-logo\"/>');");


        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    protected synchronized static ExtentReports getInstance(){
        if(extentReports == null){
            configReportExtent();
        }
        return extentReports;
    }

}
