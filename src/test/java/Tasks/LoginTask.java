package Tasks;

import Framework.Browser.Waits;
import Framework.Utils.FakersGeneration;
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

    public void login(String email, String password){
        loginValidation.validateLogin();
        loginPage.getEmailTextField().sendKeys(email);
        loginPage.getPasswordTextField().sendKeys(password);
        loginValidation.validateFillField();
        loginPage.getLoginButton().click();
        loginValidation.validateAccess();
    }
}
