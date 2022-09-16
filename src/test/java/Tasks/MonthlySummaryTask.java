package Tasks;

import Framework.Browser.Waits;
import PageObjects.MonthlySummaryPage;
import Validations.MonthlySummaryValidation;
import org.openqa.selenium.WebDriver;

public class MonthlySummaryTask {
    private static WebDriver driver;
    private static Waits waits;
    private static MonthlySummaryPage monthlySummaryPage;
    private static MonthlySummaryValidation monthlySummaryValidation;

    public MonthlySummaryTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        monthlySummaryPage = new MonthlySummaryPage(this.driver);
        monthlySummaryValidation = new MonthlySummaryValidation(this.driver);
    }

    public void removeMovement() {
        monthlySummaryValidation.validateMonthlySummaryTable();
        monthlySummaryPage.RemoveAllMoves();
        monthlySummaryValidation.validateRemoveSuccessLabel();
    }

    public void confirmFields() {
        monthlySummaryValidation.validateFields();
    }
}
