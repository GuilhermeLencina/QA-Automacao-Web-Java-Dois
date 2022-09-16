package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidation {
    private WebDriver driver;
    private Waits waits;
    private GenericPage genericPage;

    private LoginPage loginPage;
    private HomePage homePage;
    private AccountsPage accountsPage;
    private CreateMovementPage createMovementPage;
    private MonthlySummaryPage monthlySummaryPage;

    public GenericValidation(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        genericPage = new GenericPage(this.driver);
        homePage = new HomePage(this.driver);
        accountsPage = new AccountsPage(this.driver);
        createMovementPage = new CreateMovementPage(this.driver);
        monthlySummaryPage = new MonthlySummaryPage(this.driver);
    }

    public void validateLoginPage() {
        try{
            waits.loadElement(loginPage.getLoginButton());
            Assertions.assertTrue(loginPage.getLoginButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Acessou a página de login com sucesso!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateHomePage(){
        try{
            Assertions.assertTrue(homePage.getBalanceTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página home.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateAddAccountsPage(){
        try {
            Assertions.assertTrue(accountsPage.getSaveButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página adicionar contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateListAccountsPage(){
        try {
            Assertions.assertTrue(accountsPage.getAccountsTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página lista contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }


    public void validateCreateMovementPage(){
        try {
            Assertions.assertTrue(createMovementPage.getSaveButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateMonthlySummaryPage(){
        try {
            Assertions.assertTrue(monthlySummaryPage.getMonthlySummaryTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página resumo mensal.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
