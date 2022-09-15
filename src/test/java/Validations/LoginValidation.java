package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidation {
    private WebDriver driver;
    private Waits waits;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginValidation (WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
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

    public void validateFillField() {
        try {
            Assertions.assertTrue(loginPage.getEmailTextField().isDisplayed());
            Assertions.assertTrue(loginPage.getPasswordTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campos preenchidos com sucesso!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateAccess() {
        try{
            Assertions.assertEquals(homePage.getLabelSuccess().getText(), "Bem vindo, Guilherme Testador!");
            Report.logWithCapture(Status.PASS, "Validar acesso com sucesso!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

}

