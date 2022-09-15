package Framework.Utils;

import java.io.*;
import java.util.Properties;

public class FileOperation {
    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "Properties" + File.separator;

    public static Properties getProperties(String name) throws IOException {

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

    public void setPropriedade(String fileName, String propKey, String propValue) throws IOException {
        Properties prop = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties");
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
