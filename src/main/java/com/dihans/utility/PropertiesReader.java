package com.dihans.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	
	public static Properties PROP = new Properties();
	public static File F;
	public static FileInputStream FI;
	public static void loadProperties() {
		
		F = new File(System.getProperty("user.dir")
				+ File.separator +"src"+
				File.separator +"main" +
				File.separator + "java" +
				File.separator + "com"+ 
				File.separator + "dihans" + 
				File.separator + "config" +
				File.separator + "config.properties");
	
	try {
		FI = new FileInputStream(F);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		PROP.load(FI);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
