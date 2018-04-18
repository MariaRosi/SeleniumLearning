package testNGLearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AsertTest {
	
	@Test(priority=1)
	public void test1() {
		System.out.println("Test 1 started");
		Assert.assertEquals(10, 11,"Valus are not matching for Test 1");
		System.out.println("Test 1 completed");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Test 2 started");
		Assert.assertEquals(10, 10,"Valus are not matching for Test 2");
		System.out.println("Test 2 completed");
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println("Test 3 started");
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(10, 12,"Valus are not matching for Test 3");
		System.out.println("Test 3 completed");
		assertion.assertAll();
	}

}
