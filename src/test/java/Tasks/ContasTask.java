package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import Validations.ContasValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ContasTask {
    private static WebDriver driver;
    private static PageObjects.ContasPage contasPage;
    private static ContasValidation contasValidation;
    private static FakersGeneration fakersGeneration;
    FileOperation fileOperation = new FileOperation();

    public ContasTask(WebDriver driver){
        this.driver = driver;
        contasPage = new PageObjects.ContasPage(this.driver);
        contasValidation = new ContasValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
    }

    // MÉTODOS ADICIONAR CONTAS

    public void createConta() throws IOException {
        String conta = fakersGeneration.getConta();

        addDadoCSV("conta", conta);

        contasPage.getNomeTextField().sendKeys(conta);
        contasValidation.validateFilledField();
        contasPage.getButtonSalvar().click();
        contasValidation.validateLabelCreateSuccess();
    }

    public void addDadoCSV(String key, String valor) throws IOException {
        fileOperation.setPropriedade("information", key, valor);
    }

    // MÉTODOS LISTAR CONTAS

    public void editConta() {
        contasPage.getButtonEdit().click();
        contasPage.getNomeTextField().clear();
        contasPage.getNomeTextField().sendKeys(fakersGeneration.getConta());
        contasValidation.validateFilledField();
        contasPage.getButtonSalvar().click();
        contasValidation.validateLabelEditSuccess();
    }

    public void removeConta(){
        contasValidation.validateTableContas();
        contasPage.getButtonRemove().click();
        contasValidation.validateLabelRemoveSuccess();
    }
}
