package com.amazon.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import TestSetup.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	// Screenshot
	//Switch to Frame
	
	public void switchToFrame(WebElement formName)
	{
		driver.switchTo().frame(formName);
	}
	
	public static void takeScreenshot() throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");		
		String destDirFile = currentDir + "/screenshots/" + System.currentTimeMillis()+ ".png";		
		FileUtils.copyFile(srcFile, new File(destDirFile));
		System.out.println(destDirFile);
		
		
		
		
	}


}
