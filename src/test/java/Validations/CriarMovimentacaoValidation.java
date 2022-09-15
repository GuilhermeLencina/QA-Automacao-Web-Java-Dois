package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.CriarMovimentacaoPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CriarMovimentacaoValidation {
    private WebDriver driver;
    private Waits waits;
    private CriarMovimentacaoPage criarMovimentacaoPage;

    public CriarMovimentacaoValidation(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        criarMovimentacaoPage = new CriarMovimentacaoPage(this.driver);
    }

    public void validateSelectTipoMovimentacao(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getSelectTipoMovimentacao().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo select tipo de movimentação de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateDataMovimentacaoTextField(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getDataMovimentacaoTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo data de movimentação de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateDataPagamentoTextField(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getDataPagamentoTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo data de pagamento de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateDescricaoTextField(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getDescricaoTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo descrição de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateInteressadoTextField(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getInteressadoTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo interessado de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateValorTextField(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getValorTextField().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo valor de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateSelectTipoDaConta(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getSelectTipoConta().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo select tipo de conta de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateSituacaoPagoRadio(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getSituacaoPagoRadio().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo radio situação pago de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateSituacaoPendenteRadio(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getSituacaoPendenteRadio().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar campo radio situação pendente de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateButtonSalvar(){
        try{
            Assertions.assertTrue(criarMovimentacaoPage.getButtonSalvar().isDisplayed());
            Report.logWithCapture(Status.PASS, "Validar botão salvar de criar movimentação.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }

    public void validateLabelSuccess(){
        try {
            Assertions.assertEquals(criarMovimentacaoPage.getLabelSuccess().getText(), "Movimentação adicionada com sucesso!");
            Report.logWithCapture(Status.PASS, "Validar criar movimentação com sucesso!", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
