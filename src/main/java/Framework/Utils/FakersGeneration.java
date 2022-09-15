package Framework.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String name;
    private String description;
    private String conta;

    public FakersGeneration(WebDriver driver){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getName(){
        name = faker.name().firstName();
        return name;
    }

    public String getDescription(){
        description = faker.address().city();
        return description;
    }

    public String getConta(){
        conta = faker.university().name();
        return conta;
    }

}
