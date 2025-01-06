package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

public class Readconfig {

	Properties properties;
	
	String path="config.properties";

	//default consdtruvtor
	public Readconfig() throws Exception {
		
		properties=new Properties();
		
		FileInputStream fis=new FileInputStream(path);
		
		properties.load(fis);
	}
	//user defined method
	
	public String getbrowser() {
		
		String value=properties.getProperty("browser");//firefox
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser is not found in config file");
		
	}
	
	
}
