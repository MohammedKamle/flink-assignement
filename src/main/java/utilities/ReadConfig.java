package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private Properties prop;

    public ReadConfig(){
        File file = new File("src/main/resources/config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationURL(){
        return prop.getProperty("baseURL");
    }
}
