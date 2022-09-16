package PageObjects;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MonthlySummaryPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor();

    public MonthlySummaryPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getMonthSelect() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("mes"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectMonth(String tipo) {
        getMonthSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#mes option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getYearSelect() {
        WebElement labelHighlight = waits.visibilityOfElement(By.id("ano"));
        javaScriptExecutor.highlight(driver,labelHighlight);
        return  labelHighlight;
    }

    public void selectYear(String tipo) {
        getYearSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#ano option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getMonthlySummaryTable(){
        return waits.visibilityOfElement(By.id("tabelaExtrato"));
    }

    public WebElement getRemoveButton(){
        return waits.visibilityOfElement(By.cssSelector(".glyphicon-remove-circle"));
    }

    public void RemoveAllMoves(){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaExtrato tbody tr"));
        for (WebElement element : list) {
            getRemoveButton().click();
        }
    }

    public WebElement getSuccessLabel(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getDescriptionLabel() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(1)"));
    }

    public WebElement getAccountLabel() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(3)"));
    }

    public WebElement getBalanceLabel() {
        return waits.visibilityOfElement(By.cssSelector("#tabelaExtrato td:nth-child(4)"));
    }
}
