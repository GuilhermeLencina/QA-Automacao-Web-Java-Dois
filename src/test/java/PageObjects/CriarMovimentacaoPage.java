package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import Framework.Utils.TipoMovimentacao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CriarMovimentacaoPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public CriarMovimentacaoPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getLabelSuccess(){
        WebElement labelHighlight =waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }
    public WebElement getSelectTipoMovimentacao() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("tipo"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectTipoDaMovimentacao(String tipo) {
        getSelectTipoMovimentacao().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#tipo option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getDataMovimentacaoTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("data_transacao"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getDataPagamentoTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("data_pagamento"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getDescricaoTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("descricao"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getInteressadoTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("interessado"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getValorTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("valor"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getSelectTipoConta(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("conta"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectTipoDaConta(String tipo) {
        getSelectTipoConta().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#conta option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getSituacaoPagoRadio(){
        return waits.visibilityOfElement(By.id("status_pago"));
    }

    public WebElement getSituacaoPendenteRadio(){
        return waits.visibilityOfElement(By.id("status_pendente"));
    }

    public WebElement getButtonSalvar(){
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }
}
