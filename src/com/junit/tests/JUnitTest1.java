package com.junit.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest1 {
	
	@BeforeClass
	//Executes before the test run
	public static void beforeClassRun() {
		System.out.println("@@@@ Before Test Run @@@@");
		
	}
	
	@Before
	//Executes before each test run
	public void beforeTestRun() {
		System.out.println("==== Before Each Test Run ====");
		
	}
	
	
	
	@Test
	public void test1() {
		if (mMultiply(10,30)==300) {
			System.out.println("Multitply 0f 10 and 30 Passed");
		} else {
			System.out.println("Multitply 0f 10 and 30 Failed");
			fail("Multitply 0f 10 and 30 Failed");
		}
	}
	
	@Test
	public void test2() {
		if (mAdd(10,30)==40) {
			System.out.println("Addition 0f 10 and 30 Passed");
		} else {
			System.out.println("Addition 0f 10 and 30 Failed");
			fail("Addition 0f 10 and 30 Failed");
		}
	}
	
	@Test
	public void test3() {
		if (mDivide(30,10)==2) {
			System.out.println("Division 0f 30 and 10 Passed");
		} else {
			System.out.println("Division 0f 30 and 10 Failed");
			fail("Division 0f 30 and 10 Failed");
		}
	}
	
	@After
	//Executes after each test run
	public void afterTestRun() {
		System.out.println("==== After Each Test Run ====");
		
	}
	
	@AfterClass
	//Executes after the test run
	public static void afterClassRun() {
		System.out.println("@@@@ After Test Run @@@@");
		
	}
	
	//Multiply
	public int mMultiply(int x, int y) {
		return x*y;
	}
	
	//Add
	public int mAdd(int x, int y) {
		return x+y;
	}

	//Divide
	public double mDivide(int x, int y) {
		return x/y;
	}


}
