package testNGLearning;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGTest {
	
	@Test(priority=1 , description="This is for login to the application test")
	public void loginApplication() {
		System.out.println("Login to the application");
	}
	
	@Test(priority=2 , description="This is for select any item in the application test")
	public void selectItems() {
		System.out.println("Select any item");
	}

	@Test(priority=3 , description="This is for checkout the selected item test")
	public void checkoutItem() {
		System.out.println("Checkout the selected item");
	}


}
