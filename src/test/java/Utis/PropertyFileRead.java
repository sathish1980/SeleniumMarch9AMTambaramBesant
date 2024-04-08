package Utis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {
	
	static String filepath = System.getProperty("user.dir")+"\\Environment\\env.properties";
	
	public static Properties ReadPropertyfile() throws IOException
	{
		File F = new File(filepath);
		FileInputStream FS = new FileInputStream(F);
		Properties  P = new Properties();
		P.load(FS);
		return P;
		
	}

}
