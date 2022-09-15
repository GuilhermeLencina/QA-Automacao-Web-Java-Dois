package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.TestBase;
import Tasks.ContasTask;
import Tasks.GenericTask;
import Tasks.LoginTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class AddAndListAccountsTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    GenericTask genericTask = new GenericTask(driver);
    ContasTask contasTask = new ContasTask(driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/login.csv", numLinesToSkip = 1)
    @DisplayName("Validar o Adicionar e Listar contas!")
    public void addAndListAccounts(String email, String password) throws Exception{
        Report.createReportTest("Adicionar e Lista Conta com sucesso!", ReportType.GROUP);
        Report.createStep("Realizar login com sucesso");
        loginTask.login(email, password);
        Report.createStep("Selecionar Adicionar Contas");
        genericTask.selectAdicionarContas();
        Report.createStep("Criar Conta com sucesso");
        contasTask.createConta();
        Report.createStep("Editar Conta com sucesso");
        contasTask.editConta();
        Report.createStep("Remover Conta com sucesso");
        contasTask.removeConta();
    }
}
