package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import Framework.Utils.TipoMovimentacao;
import PageObjects.CriarMovimentacaoPage;
import Validations.CriarMovimentacaoValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CriarMovimentacaoTask {
    private static WebDriver driver;
    private static CriarMovimentacaoPage criarMovimentacaoPage;
    private static CriarMovimentacaoValidation criarMovimentacaoValidation;
    private static FakersGeneration fakersGeneration;
    FileOperation fileOperation = new FileOperation();
    Calendar date = Calendar.getInstance();
    SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
    Random random = new Random();
    DecimalFormat formatterDecimal = new DecimalFormat("0.00");

    public CriarMovimentacaoTask(WebDriver driver){
        this.driver = driver;
        criarMovimentacaoPage = new CriarMovimentacaoPage(this.driver);
        criarMovimentacaoValidation = new CriarMovimentacaoValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
    }

    public void fillFields() throws IOException {
        String descricao = fakersGeneration.getDescription();
        addDadoCSV("descricao", descricao);

        String teste = formatterDecimal.format(random.nextDouble(6)).replace(",", ".");

        String valor = String.valueOf(random.nextDouble(6));
        addDadoCSV("valor", teste);

        criarMovimentacaoPage.selectTipoDaMovimentacao(String.valueOf(TipoMovimentacao.RECEITA));
        criarMovimentacaoValidation.validateSelectTipoMovimentacao();

        criarMovimentacaoPage.getDataMovimentacaoTextField().sendKeys(formatterDate.format(date.getTime()));
        criarMovimentacaoValidation.validateDataMovimentacaoTextField();

        date.add(Calendar.DAY_OF_WEEK, 1);
        criarMovimentacaoPage.getDataPagamentoTextField().sendKeys(formatterDate.format(date.getTime()));
        criarMovimentacaoValidation.validateDataPagamentoTextField();

        criarMovimentacaoPage.getDescricaoTextField().sendKeys(descricao);
        criarMovimentacaoValidation.validateDescricaoTextField();

        criarMovimentacaoPage.getInteressadoTextField().sendKeys(fakersGeneration.getName());
        criarMovimentacaoValidation.validateInteressadoTextField();

        criarMovimentacaoPage.getValorTextField().sendKeys(teste);
        criarMovimentacaoValidation.validateValorTextField();

        criarMovimentacaoPage.selectTipoDaConta("");
        criarMovimentacaoValidation.validateSelectTipoDaConta();

        criarMovimentacaoPage.getSituacaoPagoRadio().click();
        criarMovimentacaoValidation.validateSituacaoPagoRadio();
    }
    public void salvarMovimentacao(){
        criarMovimentacaoValidation.validateButtonSalvar();
        criarMovimentacaoPage.getButtonSalvar().click();
        criarMovimentacaoValidation.validateLabelSuccess();
    }

    public void addDadoCSV(String key, String valor) throws IOException {
        fileOperation.setPropriedade("information", key, valor);
    }
}
