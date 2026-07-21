package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties prop;
    public ConfigReader() {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/java/resources/config.properties");//open the file
            prop.load(file);//// read the file
        }
        catch (IOException e) { //if file not exits catch something and print
            e.printStackTrace();
        }
    }
    public String getUrl(){
        return prop.getProperty("url");
    }
    public String getbrowser(){
        return prop.getProperty("browser");
    }
    public String getEmail(){
        return prop.getProperty("email");
    }
    public String getPassword(){
        return prop.getProperty("password");
    }

}





