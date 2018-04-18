package com.indeed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocatingStrategies {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Maria\\Selenium\\geckodriver.exe");
		
		//create the firefox driver
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://www.indeed.co.uk/");
		
		//By id
		//driver.findElement(By.id("text-input-what")).sendKeys("Selenium");
		
		//By Name
		//driver.findElement(By.name("q")).sendKeys("Selenium");
		
		//By LinkText
		//driver.findElement(By.linkText("Upload your CV")).click();
		
		//By ClassName
		//driver.findElement(By.className("icl-WhatWhere-button")).click();
		
		//By XPath
		String sElementValue = driver.findElement(By.xpath("//span[@alt='Indeed']")).getAttribute("class");
		System.out.println(sElementValue);
		
		//By cssSelector
		
		//By TagName

		
		driver.close();
		
		
		
		

	}

}
