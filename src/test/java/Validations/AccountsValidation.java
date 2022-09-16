package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AccountsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountsValidation {
    private WebDriver driver;
    private Waits waits;
    private AccountsPage accountsPage;

    public AccountsValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        accountsPage = new AccountsPage(this.driver);
    }

    // MÉTODOS ADICIONAR CONTAS

    public void validateFilledField() {
        try {
            Assertions.assertTrue(accountsPage.getNameTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo preenchido com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    // MÉTODOS LISTAR CONTAS

    public void validateCreateSuccessLabel() {
        try {
            Assertions.assertEquals(accountsPage.getSuccessLabel().getText(), "Conta adicionada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar criar conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateEditSuccessLabel() {
        try {
            Assertions.assertEquals(accountsPage.getSuccessLabel().getText(), "Conta alterada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar editar conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateRemoveSuccessLabel() {
        try {
            Assertions.assertEquals(accountsPage.getSuccessLabel().getText(), "Conta removida com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar remover conta com sucesso!", Screenshot.screenshot(driver));
        } catch (Exception error) {
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));

        }
    }

    public void validateAccountsTable() {
        try {
            Assertions.assertTrue(accountsPage.getAccountsTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar tabela de contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}