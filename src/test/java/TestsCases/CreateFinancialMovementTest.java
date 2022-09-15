package TestsCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.TestBase;
import Framework.Utils.TipoMovimentacao;
import Tasks.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class CreateFinancialMovementTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(this.driver);
    GenericTask genericTask = new GenericTask(this.driver);
    //HomeTask homeTask = new HomeTask(this.driver);
    ContasTask contasTask = new ContasTask(this.driver);
    CriarMovimentacaoTask criarMovimentacaoTask = new CriarMovimentacaoTask(this.driver);
    ResumoMensalTask resumoMensalTask = new ResumoMensalTask(this.driver);

    @ParameterizedTest
    @Tag("regressao")
    @CsvFileSource(resources = "/Csv/login.csv", numLinesToSkip = 1)
    @DisplayName("Validar o Criar Movimentação de contas!")
    public void createFinancialMovement(String email, String password) throws Exception {
        Report.createReportTest("Realizar uma movimentação financeira com sucesso", ReportType.GROUP);
        Report.createStep("Realizar login com sucesso!");
        loginTask.login(email, password);
        Report.createStep("Selecionar Adicionar Contas");
        genericTask.selectAdicionarContas();
        Report.createStep("Criar Conta com sucesso");
        contasTask.createConta();
        Report.createStep("Selecionar Criar Movimentação");
        genericTask.selectCriarMovimentacao();
        Report.createStep("Validar campos preenchidos");
        criarMovimentacaoTask.fillFields();
        criarMovimentacaoTask.salvarMovimentacao();
        Report.createStep("Selecionar Resumo mensal");
        genericTask.selectResumoMensal();
        Report.createStep("Validar campos Descrição e Conta em Resumo Mensal");
        resumoMensalTask.validateFields();
        Report.createStep("Deletar Movimentação em Resumo Mensal");
        resumoMensalTask.removeMovimentacao();
        Report.createStep("Selecionar Listar Contas");
        genericTask.selectListarContas();
        Report.createStep("Deletar Conta em Listar Contas");
        contasTask.removeConta();
        Report.createStep("Sair da conta");
        genericTask.selectSair();
    }
}
