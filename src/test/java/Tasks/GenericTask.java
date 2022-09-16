package Tasks;

import Framework.Browser.Waits;
import PageObjects.GenericPage;
import Validations.GenericValidation;
import org.openqa.selenium.WebDriver;

public class GenericTask {
    private static WebDriver driver;
    private static Waits waits;
    private static GenericPage genericPage;
    private static GenericValidation genericValidation;

    public GenericTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        genericPage = new GenericPage(this.driver);
        genericValidation = new GenericValidation(this.driver);
    }

    public void selectHome(){
        genericPage.getHomeButton().click();
        genericValidation.validateHomePage();
    }

    public void selectAddAccounts(){
        genericPage.getAccountsButton().click();
        genericPage.getAddAccountsButton().click();
        genericValidation.validateAddAccountsPage();
    }

    public void selectListAccounts(){
        genericPage.getAccountsButton().click();
        genericPage.getListAccountsButton().click();
        genericValidation.validateListAccountsPage();
    }

    public void selectCreateMovement(){
        genericPage.getCreateMovementButton().click();
        genericValidation.validateCreateMovementPage();
    }

    public void selectMonthlySummary(){
        genericPage.getMonthlySummaryButton().click();
        genericValidation.validateMonthlySummaryPage();
    }

    public void selectExit(){
        genericPage.getExitButton().click();
        genericValidation.validateLoginPage();
    }
}
