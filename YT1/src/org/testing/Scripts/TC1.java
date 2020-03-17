package org.testing.Scripts;

import java.io.IOException;

import org.testing.base.Base;
import org.testing.pages.Signin;
import org.testing.utilities.Screenshot;
import org.testing.utilities.logs;
import org.testng.annotations.Test;


public class TC1 extends Base {
	
	@Test
	public void testCase1() throws InterruptedException, IOException {
	Signin s = new Signin(driver, pr);
	 s.login("ivss35478@gmail.com", "ishu@1234");   
	 Screenshot.takeimg(driver, "D:\\project_ScreenShot\\img1.png");
	 logs.takelogs("TC1", "login Succesful");
	
	}
	
}
