import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
		// 1 Lấy ra giá trị property bất kỳ theo key.
	// Đường dẫn đến file configs.properties trong folder configuration
			private static String CONFIG_PATH = "./configuration/configs.properties";
			// Lấy ra giá trị property bất kỳ theo key.
			public static String getProperty(String key) {
		        Properties props = new Properties();
		        String value = null;

		        try (FileInputStream file=new FileInputStream(CONFIG_PATH))
		        {
		            props.load(file);
		            value = props.getProperty(key);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        return value;
		    }

	}
