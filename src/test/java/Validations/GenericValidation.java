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
    private ContasPage contasPage;
    private CriarMovimentacaoPage criarMovimentacaoPage;
    private ResumoMensalPage resumoMensalPage;

    public GenericValidation(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        genericPage = new GenericPage(this.driver);
        homePage = new HomePage(this.driver);
        contasPage = new ContasPage(this.driver);
        criarMovimentacaoPage = new CriarMovimentacaoPage(this.driver);
        resumoMensalPage = new ResumoMensalPage(this.driver);
    }

    public void validateLogin() {
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
            Assertions.assertTrue(homePage.getTabela().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página home.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateAdicionarContasPage(){
        try {
            Assertions.assertTrue(contasPage.getButtonSalvar().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página adicionar contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateListarContasPage(){
        try {
            Assertions.assertTrue(contasPage.getTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página lista contas.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }


    public void validateCriarMovimentacaoPage(){
        try {
            Assertions.assertTrue(criarMovimentacaoPage.getButtonSalvar().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateResumoMensal(){
        try {
            Assertions.assertTrue(resumoMensalPage.getTable().isDisplayed());
            Report.logWithCapture(Status.PASS, "Está na página resumo mensal.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
