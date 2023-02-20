package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
             static Properties properties;
             static {

                 String filePath="configuration.properties";

                 try {
                     FileInputStream fis=new FileInputStream(filePath);

                     properties=new Properties();
                     properties.load(fis);
                 } catch (IOException e) {
                     System.out.println("Properties cannot read");
                     throw new RuntimeException(e);
                 }

             }


             public  static String getProperty(String key){

                 return properties.getProperty(key);

             }
}
