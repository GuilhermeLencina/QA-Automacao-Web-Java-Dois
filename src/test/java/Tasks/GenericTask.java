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
        genericPage.getButtonHome().click();
        genericValidation.validateHomePage();
    }

    public void selectAdicionarContas(){
        genericPage.getButtonContas().click();
        genericPage.getButtoAdicionarContas().click();
        genericValidation.validateAdicionarContasPage();
    }

    public void selectListarContas(){
        genericPage.getButtonContas().click();
        genericPage.getButtoListarContas().click();
        genericValidation.validateListarContasPage();
    }

    public void selectCriarMovimentacao(){
        genericPage.getButtonCriarMovimentacao().click();
        genericValidation.validateCriarMovimentacaoPage();
    }

    public void selectResumoMensal(){
        genericPage.getButtonResumoMensal().click();
        genericValidation.validateResumoMensal();
    }

    public void selectSair(){
        genericPage.getButtonSair().click();
        genericValidation.validateLogin();
    }
}
