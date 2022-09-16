package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FileOperation;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.DecimalFormat;

public class HomeValidation {
    private WebDriver driver;
    private Waits waits;
    private HomePage homePage;
    DecimalFormat formatterDecimal = new DecimalFormat("0.00");

    public HomeValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        homePage = new HomePage(this.driver);
    }

    public String calculateBalance() throws IOException {
        double valorDespesa = Double.parseDouble(FileOperation.getProperties("information").getProperty("valorDespesa"));
        double valorReceita = Double.parseDouble(FileOperation.getProperties("information").getProperty("valorReceita"));


        String balance = formatterDecimal.format(valorReceita - valorDespesa);

        return String.valueOf(balance).replace(",", ".");
    }

    public void validateBalance() throws IOException {
//        Double valorDespesa = Double.parseDouble(FileOperation.getProperties("information").getProperty("valorDespesa"));
//        Double valorReceita = Double.parseDouble(FileOperation.getProperties("information").getProperty("valorReceita"));
//        Double saldo = valorReceita - valorDespesa;
//        String saldoFormatter = formatterDecimal.format(String.valueOf(saldo));
        try {
            Assertions.assertEquals(this.calculateBalance(), homePage.getBalanceLabel().getText());

            Report.logWithCapture(Status.PASS, "Validar campos Conta e Descrição.", Screenshot.screenshot(driver));
        }catch (Exception error){
            Report.logWithCapture(Status.FAIL, error.getMessage(), Screenshot.screenshot(driver));
        }
    }
}
