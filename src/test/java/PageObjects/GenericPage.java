package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GenericPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public GenericPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getButtonHome(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Home')]"));
    }

    public WebElement getButtonContas(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Contas')]"));
    }

    public WebElement getButtoAdicionarContas(){
        return waits.visibilityOfElement(By.cssSelector(".dropdown-menu li:nth-child(1) a"));
    }

    public WebElement getButtoListarContas(){
        return waits.visibilityOfElement(By.cssSelector(".dropdown-menu li:nth-child(2) a"));
    }

    public WebElement getButtonCriarMovimentacao(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Criar Movimentação')]"));
    }

    public WebElement getButtonResumoMensal(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Resumo Mensal')]"));
    }

    public WebElement getButtonSair(){
        WebElement labelHighlight = waits.visibilityOfElement(By.xpath("//a[contains(text(),'Sair')]"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }
}
