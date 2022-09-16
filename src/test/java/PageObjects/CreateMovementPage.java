package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateMovementPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public CreateMovementPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSuccessLabel(){
        WebElement labelHighlight =waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getMovementTypeSelect() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("tipo"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectMovementType(String tipo) {
        getMovementTypeSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#tipo option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getMovementDateTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("data_transacao"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getPaymentDateTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("data_pagamento"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getDescriptionTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("descricao"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getInterestedTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("interessado"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getValueTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("valor"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getAccountTypeSelect(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("conta"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectAccountType(String tipo) {
        getAccountTypeSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#conta option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getPaidSituationRadio(){
        return waits.visibilityOfElement(By.id("status_pago"));
    }

    public WebElement getPendingSituationRadio(){
        return waits.visibilityOfElement(By.id("status_pendente"));
    }

    public WebElement getSaveButton(){
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }
}
