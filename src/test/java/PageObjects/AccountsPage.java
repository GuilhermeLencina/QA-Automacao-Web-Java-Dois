package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    // ELEMENTOS ADICIONAR CONTAS
    public WebElement getNameTextField(){
        WebElement labelHighlight = waits.visibilityOfElement(By.id("nome"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getSaveButton(){
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }

    // ELEMENTOS LISTAR CONTAS
    public WebElement getSuccessLabel(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getAccountsTable(){
        return waits.visibilityOfElement(By.id("tabelaContas"));
    }

    public WebElement getEditButton(){
        return waits.visibilityOfElement(By.cssSelector(".glyphicon.glyphicon-edit"));
    }

    public WebElement getRemoveButton() {
        return waits.visibilityOfElement(By.cssSelector(".glyphicon.glyphicon-remove-circle"));
    }
}
