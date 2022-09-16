package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import Framework.Utils.TipoMovimentacao;
import PageObjects.CreateMovementPage;
import Validations.CreateMovementValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CreateMovementTask {
    private static WebDriver driver;
    private static CreateMovementPage createMovementPage;
    private static CreateMovementValidation createMovementValidation;
    private static FakersGeneration fakersGeneration;
    FileOperation fileOperation = new FileOperation();
    Calendar date = Calendar.getInstance();
    SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
    Random random = new Random();
    DecimalFormat formatterDecimal = new DecimalFormat("0.00");

    public CreateMovementTask(WebDriver driver){
        this.driver = driver;
        createMovementPage = new CreateMovementPage(this.driver);
        createMovementValidation = new CreateMovementValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
    }

    public void addDadoCSV(String key, String valor) throws IOException {
        fileOperation.setPropriedade("information", key, valor);
    }

    public void fillRevenueFields() throws IOException {
        String descricao = fakersGeneration.getDescription();
        addDadoCSV("descricao", descricao);

        String valorReceita = formatterDecimal.format(random.nextDouble(10)).replace(",", ".");
        addDadoCSV("valorReceita", valorReceita);

        createMovementPage.selectMovementType(String.valueOf(TipoMovimentacao.RECEITA));
        createMovementValidation.validateMovementTypeSelect();

        createMovementPage.getMovementDateTextField().sendKeys(formatterDate.format(date.getTime()));
        createMovementValidation.validateMovementDateTextField();

        date.add(Calendar.DAY_OF_WEEK, 1);
        createMovementPage.getPaymentDateTextField().sendKeys(formatterDate.format(date.getTime()));
        createMovementValidation.validatePaymentDateTextField();

        createMovementPage.getDescriptionTextField().sendKeys(descricao);
        createMovementValidation.validateDescriptionTextField();

        createMovementPage.getInterestedTextField().sendKeys(fakersGeneration.getName());
        createMovementValidation.validateInterestedTextField();

        createMovementPage.getValueTextField().sendKeys(valorReceita);
        createMovementValidation.validateValueTextField();

        createMovementPage.selectAccountType("");
        createMovementValidation.validateAccountTypeSelect();

        createMovementPage.getPaidSituationRadio().click();
        createMovementValidation.validatePaidSituationRadio();
    }

    public void fillExpenseFields() throws IOException {
        String descricao = fakersGeneration.getDescription();
        addDadoCSV("descricao", descricao);

        String valorDespesa = formatterDecimal.format(random.nextDouble(2)).replace(",", ".");
        addDadoCSV("valorDespesa", valorDespesa);

        createMovementPage.selectMovementType(String.valueOf(TipoMovimentacao.DESPESA));
        createMovementValidation.validateMovementTypeSelect();

        date.add(Calendar.DAY_OF_WEEK, - 2);
        createMovementPage.getMovementDateTextField().sendKeys(formatterDate.format(date.getTime()));
        createMovementValidation.validateMovementDateTextField();

        createMovementPage.getPaymentDateTextField().sendKeys(formatterDate.format(date.getTime()));
        createMovementValidation.validatePaymentDateTextField();

        createMovementPage.getDescriptionTextField().sendKeys(descricao);
        createMovementValidation.validateDescriptionTextField();

        createMovementPage.getInterestedTextField().sendKeys(fakersGeneration.getName());
        createMovementValidation.validateInterestedTextField();

        createMovementPage.getValueTextField().sendKeys(valorDespesa);
        createMovementValidation.validateValueTextField();

        createMovementPage.selectAccountType("");
        createMovementValidation.validateAccountTypeSelect();

        createMovementPage.getPaidSituationRadio().click();
        createMovementValidation.validatePaidSituationRadio();
    }

    public void saveMovement(){
        createMovementValidation.validateSaveButton();
        createMovementPage.getSaveButton().click();
        createMovementValidation.validateSuccessLabel();
    }
}
