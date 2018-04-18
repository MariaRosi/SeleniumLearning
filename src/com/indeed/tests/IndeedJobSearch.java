package com.indeed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IndeedJobSearch {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "D:\\Maria\\Selenium\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:\\Maria\\Selenium\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//create the firefox driver
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.indeed.co.uk/");
		
		//get the What filed and enter Selenium
		driver.findElement(By.id("text-input-what")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		//get the Location field and enter London
		driver.findElement(By.id("text-input-where")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("text-input-where")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.id("text-input-where")).sendKeys("London");
		Thread.sleep(2000);
		
		//click on JobSearch
		driver.findElement(By.className("icl-WhatWhere-button")).click();
		
		//get the search count
		String sTitle = driver.getTitle();
		String sSearchCount = driver.findElement(By.id("searchCount")).getText();
		
		System.out.println(sTitle);
		System.out.println(sSearchCount);
		
		driver.close();
		
		
		
		

	}

}
