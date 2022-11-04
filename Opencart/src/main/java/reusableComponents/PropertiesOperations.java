package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations 
{

	static Properties propertiesfile = new Properties();

	public static String getPropertiesValue(String key) throws Exception 
	{
		//load data from properties file
		String path="./Configuration//config.properties";
		FileInputStream fis = new FileInputStream(path);
		propertiesfile.load(fis);

		//read data
		String value=propertiesfile.getProperty(key).toString();
		if(StringUtils.isEmpty(value))
		{
			throw new Exception("value is not sepcified for key:"+key+"  in the properties file");
		}

		return value;


	}

}
