package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.CreateMovementPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CreateMovementValidation {
    private WebDriver driver;
    private Waits waits;
    private CreateMovementPage createMovementPage;

    public CreateMovementValidation(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        createMovementPage = new CreateMovementPage(this.driver);
    }

    public void validateMovementTypeSelect(){
        try{
            Assertions.assertTrue(createMovementPage.getMovementTypeSelect().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo select tipo de movimentação de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateMovementDateTextField(){
        try{
            Assertions.assertTrue(createMovementPage.getMovementDateTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo data de movimentação de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validatePaymentDateTextField(){
        try{
            Assertions.assertTrue(createMovementPage.getPaymentDateTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo data de pagamento de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateDescriptionTextField(){
        try{
            Assertions.assertTrue(createMovementPage.getDescriptionTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo descrição de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateInterestedTextField(){
        try{
            Assertions.assertTrue(createMovementPage.getInterestedTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo interessado de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateValueTextField(){
        try{
            Assertions.assertTrue(createMovementPage.getValueTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo valor de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateAccountTypeSelect(){
        try{
            Assertions.assertTrue(createMovementPage.getAccountTypeSelect().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo select tipo de conta de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validatePaidSituationRadio(){
        try{
            Assertions.assertTrue(createMovementPage.getPaidSituationRadio().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo radio situação pago de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validatePendingSituationRadio(){
        try{
            Assertions.assertTrue(createMovementPage.getPendingSituationRadio().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo radio situação pendente de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateSaveButton(){
        try{
            Assertions.assertTrue(createMovementPage.getSaveButton().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar botão salvar de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateSuccessLabel(){
        try {
            Assertions.assertEquals(createMovementPage.getSuccessLabel().getText(), "Movimentação adicionada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar criar movimentação com sucesso!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
