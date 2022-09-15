package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getLabelSuccess(){
        return waits.visibilityOfElement(By.cssSelector(".alert.alert-success"));
    }
    public WebElement getTabela(){
        return waits.visibilityOfElement(By.id("tabelaSaldo"));
    }
}
