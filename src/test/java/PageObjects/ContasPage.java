package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContasPage {
    private WebDriver driver;
    private Waits waits;

    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();


    public ContasPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    // ELEMENTOS ADICIONAR CONTAS
    public WebElement getNomeTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("nome"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getButtonSalvar(){
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }

    // ELEMENTOS LISTAR CONTAS

    public WebElement getLabelSuccess(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getTable(){
        return waits.visibilityOfElement(By.id("tabelaContas"));
    }

    public WebElement getButtonEdit(){
        return waits.visibilityOfElement(By.cssSelector(".glyphicon.glyphicon-edit"));
    }

    public WebElement getButtonRemove() {
        return waits.visibilityOfElement(By.cssSelector(".glyphicon.glyphicon-remove-circle"));
    }
}
