package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FileOperation;
import PageObjects.MonthlySummaryPage;
import Tasks.CreateMovementTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MonthlySummaryValidation {
    private WebDriver driver;
    private Waits waits;
    private MonthlySummaryPage monthlySummaryPage;
    private CreateMovementTask createMovementTask;

    public MonthlySummaryValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        monthlySummaryPage = new MonthlySummaryPage(this.driver);
        createMovementTask = new CreateMovementTask(this.driver);
    }

    public void validateMonthlySummaryTable() {
        try {
            Assertions.assertTrue(monthlySummaryPage.getMonthlySummaryTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar tabela de resumo mensal.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateRemoveSuccessLabel() {
        try {
            Assertions.assertEquals(monthlySummaryPage.getSuccessLabel().getText(), "Movimentação removida com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar remover movimentação com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));

        }
    }

    public void validateFields() {
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("conta"),
                            monthlySummaryPage.getAccountLabel().getText()),

                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("descricao"),
                            monthlySummaryPage.getDescriptionLabel().getText()),

                    () -> Assertions.assertEquals(FileOperation.getProperties("information").getProperty("valorReceita"),
                            monthlySummaryPage.getBalanceLabel().getText()));

            Report.logWithCapture(Status.PASS, "Validar campos Conta e Descrição.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
