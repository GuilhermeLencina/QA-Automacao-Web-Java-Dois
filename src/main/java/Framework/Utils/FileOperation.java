package Framework.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileOperation {
    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "Properties" + File.separator;

    public Properties getProperties(String name) throws IOException {

        InputStream inputStream = null;
        Properties properties = new Properties();

        try {
            File file = new File(DIR_PATH_PROPERTIES + name + ".properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        } catch (Exception error) {
            System.out.println("Não carregou o arquivo de properties!!" + error.getMessage());
        }finally {
            assert inputStream != null;
            inputStream.close();
        }
        return properties;
    }

}
