package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class ResumoMensalPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public ResumoMensalPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSelectMes() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("mes"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectMes(String tipo) {
        getSelectMes().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#mes option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getSelectAno() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("ano"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectAno(String tipo) {
        getSelectAno().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#ano option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getTable(){
        return waits.visibilityOfElement(By.id("tabelaExtrato"));
    }

    public WebElement getButtonRemove(){
        return waits.visibilityOfElement(By.cssSelector(".glyphicon.glyphicon-remove-circle"));
    }

    public WebElement getLabelSuccess(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getLabelDescricao() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(1)"));
    }

    public WebElement getLabelConta() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(3)"));
    }

    public WebElement getLabelValor() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(4)"));
    }
}
