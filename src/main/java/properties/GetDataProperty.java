package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataProperty {

    private Properties properties;
    public String getValueProperty(String key) throws IOException {
        properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/data.properties");
        properties.load(fileInputStream);

        return properties.getProperty(key);
    }

}