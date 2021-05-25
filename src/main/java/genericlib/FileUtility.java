package genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String propertydata(String propertyPath,String name) throws Throwable{
		FileInputStream fis= new FileInputStream(propertyPath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(name);
	} 
}
