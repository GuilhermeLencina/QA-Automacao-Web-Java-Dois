package Tasks;

import Framework.Browser.Waits;
import PageObjects.ResumoMensalPage;
import Validations.ResumoMensalValidation;
import org.openqa.selenium.WebDriver;

public class ResumoMensalTask {
    private static WebDriver driver;
    private static Waits waits;
    private static ResumoMensalPage resumoMensalPage;
    private static ResumoMensalValidation resumoMensalValidation;

    public ResumoMensalTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        resumoMensalPage = new ResumoMensalPage(this.driver);
        resumoMensalValidation = new ResumoMensalValidation(this.driver);
    }

    public void removeMovimentacao() {
        resumoMensalValidation.validateTableResumoMensal();
        resumoMensalPage.getButtonRemove().click();
        resumoMensalValidation.validateLabelRemoveSuccess();
    }

    public void validateFields() {
        resumoMensalValidation.validateFields();
    }
}
