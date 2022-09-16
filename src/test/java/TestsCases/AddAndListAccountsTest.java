package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.AccountsTask;
import Tasks.GenericTask;
import Tasks.LoginTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class AddAndListAccountsTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    GenericTask genericTask = new GenericTask(driver);
    AccountsTask accountsTask = new AccountsTask(driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/login.csv", numLinesToSkip = 1)
    @DisplayName("Validar o Adicionar e Listar contas!")
    public void addAndListAccounts(String email, String password) throws Exception{
        try {
            Report.createReportTest("Adicionar e Lista Conta com sucesso!", ReportType.GROUP);
            Report.createStep("Realizar login com sucesso");
            loginTask.accessAccount(email, password);
            Report.createStep("Selecionar Adicionar Contas");
            genericTask.selectAddAccounts();
            Report.createStep("Criar Conta com sucesso");
            accountsTask.generateAccount();
            Report.createStep("Editar Conta com sucesso");
            accountsTask.editAccount();
            Report.createStep("Remover Conta com sucesso");
            accountsTask.removeAccount();
            Report.createStep("Sair da conta");
            genericTask.selectExit();
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
