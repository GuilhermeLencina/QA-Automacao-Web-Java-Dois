package Validations;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.ContasPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ContasValidation {
    private WebDriver driver;
    private Waits waits;
    private ContasPage contasPage;

    public ContasValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        contasPage = new ContasPage(this.driver);
    }

    // MÉTODOS ADICIONAR CONTAS

    public void validateFilledField() {
        try {
            Assertions.assertTrue(contasPage.getNomeTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo preenchido com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    // MÉTODOS LISTAR CONTAS

    public void validateLabelCreateSuccess() {
        try {
            Assertions.assertEquals(contasPage.getLabelSuccess().getText(), "Conta adicionada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar criar conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateLabelEditSuccess() {
        try {
            Assertions.assertEquals(contasPage.getLabelSuccess().getText(), "Conta alterada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar editar conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateLabelRemoveSuccess() {
        try {
            Assertions.assertEquals(contasPage.getLabelSuccess().getText(), "Conta removida com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar remover conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));

        }
    }

    public void validateTableContas() {
        try {
            Assertions.assertTrue(contasPage.getTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar tabela de contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}