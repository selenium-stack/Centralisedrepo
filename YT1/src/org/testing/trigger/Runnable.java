package org.testing.trigger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Runnable {

	public static void main(String[] args) throws Exception {
	
		XmlSuite xs = new XmlSuite();
		xs.setName("Suite1");
        XmlTest xt = new XmlTest(xs);
        File f = new File("D:\\Selenium_exe\\file.xls");
        
        Workbook wk = Workbook.getWorkbook(f);
	              Sheet s = wk.getSheet(0); 
                          int rows  = s.getRows();
                          
                        ArrayList<XmlClass> al1 = new ArrayList<XmlClass>();
                          for(int i = 1;i< rows;i++) {
	                                  Cell c =s.getCell(4, i);    
	                        if (c.getContents().equals("Y")) {
	       	
	                        	Cell pkgname =  s.getCell(2, i);
	                        	Cell clsname =  s.getCell(3, i);
	                        	 String v = pkgname.getContents() + "."+ clsname.getContents();	                        	 
	                        	 XmlClass c1 = new XmlClass(v);
	                        	 al1.add(c1);  	 
							}                        	  
	              }
                          System.out.println(al1.size());
                          xt.setClasses(al1);
                          ArrayList<XmlTest> al2 = new ArrayList<XmlTest>();
                          al2.add(xt);
                          xs.setTests(al2);
	                    ArrayList<XmlSuite> al3 = new ArrayList<XmlSuite>();
	                     al3.add(xs);
                     	 TestNG tn = new TestNG();
                       	  tn.setXmlSuites(al3);
                        	tn.run();
                          
	}
}	
