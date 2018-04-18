package testNGLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryUsecases {
	
	@Test(retryAnalyzer = runner.RetryAnalyzer.class)
	public void testcase1() {
		Assert.assertEquals(false, true);
	}
	
	@Test(retryAnalyzer = runner.RetryAnalyzer.class)
	public void testcase2() {
		Assert.assertEquals(false, true);
	}
	
	@Test(retryAnalyzer = runner.RetryAnalyzer.class)
	public void testcase3() {
		Assert.assertEquals(true, true);
	}

}
