package Tasks;

import Framework.Browser.Waits;
import PageObjects.HomePage;
import Validations.HomeValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomeTask {
    private WebDriver driver;
    private Waits waits;
    private HomePage homePage;

    private HomeValidation homeValidation;

    public HomeTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        homePage = new HomePage(this.driver);
        homeValidation = new HomeValidation(this.driver);
    }

    public void confirmBalance() throws IOException {
        homeValidation.validateBalance();
    }
}
