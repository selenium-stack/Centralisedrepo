package org.testing.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;



public class logs {

	public static void takelogs(String classname, String msg) {
		
		DOMConfigurator.configure("../YT1/layout.xml");
		
		
		Logger l = Logger.getLogger(classname);
		l.info(msg);
	}
}
