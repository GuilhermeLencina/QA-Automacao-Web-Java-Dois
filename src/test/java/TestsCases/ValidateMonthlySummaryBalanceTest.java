package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class ValidateMonthlySummaryBalanceTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    GenericTask genericTask = new GenericTask(this.driver);
    HomeTask homeTask = new HomeTask(this.driver);
    AccountsTask accountsTask = new AccountsTask(this.driver);
    CreateMovementTask createMovementTask = new CreateMovementTask(this.driver);
    MonthlySummaryTask monthlySummaryTask = new MonthlySummaryTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/login.csv", numLinesToSkip = 1)
    @DisplayName("Validar o Saldo do Resumo Mensal!")
    public void validateMonthlySummaryBalance(String email, String password) throws Exception {
        try {
            Report.createReportTest("Realizar uma movimentação financeira com sucesso", ReportType.GROUP);
            Report.createStep("Realizar login com sucesso!");
            loginTask.accessAccount(email, password);
            Report.createStep("Selecionar Adicionar Contas");
            genericTask.selectAddAccounts();
            Report.createStep("Criar Conta com sucesso");
            accountsTask.generateAccount();
            Report.createStep("Selecionar Criar Movimentação");
            genericTask.selectCreateMovement();
            Report.createStep("Criar Movimentação de Receita Paga");
            createMovementTask.fillRevenueFields();
            createMovementTask.saveMovement();
            Report.createStep("Criar Movimentação de Despesa Paga");
            createMovementTask.fillExpenseFields();
            createMovementTask.saveMovement();
            Report.createStep("Selecionar Home");
            genericTask.selectHome();
            Report.createStep("Validar Saldo da Conta");
            homeTask.confirmBalance();
            Report.createStep("Selecionar Resumo Mensal");
            genericTask.selectMonthlySummary();
            Report.createStep("Deletar Movimentações em Resumo Mensal");
            monthlySummaryTask.removeMovement();
            Report.createStep("Selecionar Listar Contas");
            genericTask.selectListAccounts();
            Report.createStep("Deletar Conta em Listar Contas");
            accountsTask.removeAccount();
            Report.createStep("Sair da conta");
            genericTask.selectExit();
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
