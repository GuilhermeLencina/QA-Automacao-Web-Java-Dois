package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FileOperation;
import PageObjects.ResumoMensalPage;
import Tasks.CriarMovimentacaoTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

public class ResumoMensalValidation {
    private WebDriver driver;
    private Waits waits;
    private ResumoMensalPage resumoMensalPage;
    private CriarMovimentacaoTask criarMovimentacaoTask;

    public ResumoMensalValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        resumoMensalPage = new ResumoMensalPage(this.driver);
        criarMovimentacaoTask = new CriarMovimentacaoTask(this.driver);
    }

    public void validateTableResumoMensal() {
        try {
            Assertions.assertTrue(resumoMensalPage.getTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar tabela de resumo mensal.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateLabelRemoveSuccess() {
        try {
            Assertions.assertEquals(resumoMensalPage.getLabelSuccess().getText(), "Movimentação removida com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar remover movimentação com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));

        }
    }

    public void validateFields() {
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("conta"),
                            resumoMensalPage.getLabelConta().getText()),

                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("descricao"),
                            resumoMensalPage.getLabelDescricao().getText()),

                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("valor"),
                            resumoMensalPage.getLabelValor().getText()));

            Report.logWithCapture(Status.PASS, "Validar campos Conta e Descrição.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
