package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import PageObjects.AccountsPage;
import Validations.AccountsValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AccountsTask {
    private static WebDriver driver;
    private static AccountsPage accountsPage;
    private static AccountsValidation accountsValidation;
    private static FakersGeneration fakersGeneration;
    FileOperation fileOperation = new FileOperation();

    public AccountsTask(WebDriver driver){
        this.driver = driver;
        accountsPage = new AccountsPage(this.driver);
        accountsValidation = new AccountsValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
    }

    public void addDadoCSV(String key, String valor) throws IOException {
        fileOperation.setPropriedade("information", key, valor);
    }

    // MÉTODOS ADICIONAR CONTAS

    public void generateAccount() throws IOException {
        String conta = fakersGeneration.getConta();
        addDadoCSV("conta", conta);

        accountsPage.getNameTextField().sendKeys(conta);
        accountsValidation.validateFilledField();
        accountsPage.getSaveButton().click();
        accountsValidation.validateCreateSuccessLabel();
    }

    // MÉTODOS LISTAR CONTAS

    public void editAccount() {
        accountsPage.getEditButton().click();
        accountsPage.getNameTextField().clear();
        accountsPage.getNameTextField().sendKeys(fakersGeneration.getConta());
        accountsValidation.validateFilledField();
        accountsPage.getSaveButton().click();
        accountsValidation.validateEditSuccessLabel();
    }

    public void removeAccount(){
        accountsValidation.validateAccountsTable();
        accountsPage.getRemoveButton().click();
        accountsValidation.validateRemoveSuccessLabel();
    }
}
