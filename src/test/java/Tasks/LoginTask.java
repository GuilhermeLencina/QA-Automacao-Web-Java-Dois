package Tasks;

import Framework.Browser.Waits;
import PageObjects.LoginPage;
import Validations.LoginValidation;
import org.openqa.selenium.WebDriver;

public class LoginTask {
    private static WebDriver driver;
    private static Waits waits;
    private static LoginPage loginPage;
    private static LoginValidation loginValidation;

    public LoginTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
    }

    public void accessAccount(String email, String password){
        loginValidation.validateLogin();
        loginPage.getEmailTextField().sendKeys(email);
        loginPage.getPasswordTextField().sendKeys(password);
        loginValidation.validateFilledFields();
        loginPage.getLoginButton().click();
        loginValidation.validateAccess();
    }
}
