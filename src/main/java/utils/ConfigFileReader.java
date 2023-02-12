package utils;
import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    public Properties properties;
    File file = new File("src/main/resources/config.properties");
    String propertyFilePath  = file.getAbsolutePath();

    public ConfigFileReader() {
        FileReader fileReader;
        BufferedReader reader=null;
        try {
            fileReader= new FileReader(propertyFilePath);
            reader = new BufferedReader(fileReader);
            properties = new Properties();
            properties.load(reader);

            } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getBrowser() {
        String driverPath = properties.getProperty("Browser");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getDefaultTimeOut() {
        String defaultTimeOut = properties.getProperty("defaultTimeOut");
        if (defaultTimeOut != null) return Long.parseLong(defaultTimeOut);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getUrl() {
        String url = properties.getProperty("URL");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


}
