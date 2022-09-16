package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSuccessLabel(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }
    public WebElement getBalanceTable(){
        return waits.visibilityOfElement(By.id("tabelaSaldo"));
    }

    public WebElement getAccountLabel(){
        WebElement labelHighlight = waits.visibilityOfElement(By.cssSelector("#tabelaSaldo td:nth-child(1)"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public WebElement getBalanceLabel(){
        WebElement labelHighlight = waits.visibilityOfElement(By.cssSelector("#tabelaSaldo td:nth-child(2)"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }
}
