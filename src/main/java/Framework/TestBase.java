package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import Framework.Utils.FileOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase extends DriverManager {
    private static WebDriver driver;
    private static FileOperation fileOperation = new FileOperation();

    public static WebDriver getDriver(){
        driver = getDriver(TypeBrowser.CHROME);
        return driver;
    }

    @BeforeEach
    public void driverSetup() throws IOException {
        String URL = fileOperation.getProperties("url").getProperty("url.index");
        getDriver().get(URL);
    }

    @AfterEach
    public void driverShuttingDown(){
        //Report.close();
        quitDriver();
    }

}
