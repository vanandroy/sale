package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
		
	}
}
