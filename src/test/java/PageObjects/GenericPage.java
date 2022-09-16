package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public GenericPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getHomeButton(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Home')]"));
    }

    public WebElement getAccountsButton(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Contas')]"));
    }

    public WebElement getAddAccountsButton(){
        return waits.visibilityOfElement(By.cssSelector(".dropdown-menu li:nth-child(1) a"));
    }

    public WebElement getListAccountsButton(){
        return waits.visibilityOfElement(By.cssSelector(".dropdown-menu li:nth-child(2) a"));
    }

    public WebElement getCreateMovementButton(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Criar Movimentação')]"));
    }

    public WebElement getMonthlySummaryButton(){
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'Resumo Mensal')]"));
    }

    public WebElement getExitButton(){
        WebElement labelHighlight = waits.visibilityOfElement(By.xpath("//a[contains(text(),'Sair')]"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }
}
