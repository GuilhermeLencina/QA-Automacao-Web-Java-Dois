package Framework.Utils;

public enum TipoMovimentacao {
    RECEITA("Receita"),
    DESPESA("Despesa");

    private String text;

    TipoMovimentacao(String text){
        this.text = text;
    }

    public String toString(){
        return text;
    }
}
