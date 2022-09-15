package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.TestBase;
import Tasks.LoginTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class AccessSeuBarrigaTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/login.csv", numLinesToSkip = 1)
    @DisplayName("Validar o acesso com sucesso!")
    public void accessSeuBarriga(String email, String password) throws Exception{
        Report.createReportTest("Realizar acesso com sucesso", ReportType.GROUP);
        Report.createStep("Realizar login com sucesso!");
        loginTask.login(email, password);
    }
}
