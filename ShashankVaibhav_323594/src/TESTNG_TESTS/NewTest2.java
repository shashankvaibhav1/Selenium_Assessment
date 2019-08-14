/*
 * Name: Shashank Vaibhav
 * Emp.Id: 323594
 */
package TESTNG_TESTS;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class NewTest2 extends NewTest1 {
	@Test(dataProvider = "product", priority=9)
	public void verifyProduct(String pname) {
		String actual = sc.get_product_name(pname);
		pname = pname + " ";
		log.info("======================================================");	
		log.info("verifyProduct() is invoked");
		log.info("EXPECTED RESULT: "+ pname);
		log.info("ACTUAL RESULT: "+ actual);
		Assert.assertEquals(actual, pname);
		log.info("TEST RESULT: PASS");
		log.info("======================================================");	
	}

	@DataProvider
	public String[] product() {
		String[] pname = new String[file2.size()];
		for(int i=0; i<file2.size(); i++) {
			pname[i] = file2.get(i).get(0).toString();
		}
		return pname;		
	}
	
	@Test(dataProvider = "price", priority=10)
	public void verifyPrice(String price) {
		String actual = sc.get_product_price(price);
		float actual_price = Float.parseFloat(actual.replaceAll("[^0-9.]+", ""));
		float expected_price = Float.parseFloat(price);
		log.info("======================================================");	
		log.info("verifyPrice() is invoked");
		log.info("EXPECTED RESULT: "+ expected_price);
		log.info("ACTUAL RESULT: "+ actual_price);
		Assert.assertEquals(actual_price, expected_price);
		log.info("TEST RESULT: PASS");
		log.info("======================================================");	
	}

	@DataProvider
	public String[] price() {
		String[] pname = new String[file2.size()];
		for(int i=0; i<file2.size(); i++) {
			pname[i] = file2.get(i).get(1).toString();
		}
		return pname;		
	}
	
//	@DataProvider(name = "ex")
//	public String[][] get_excel(){
//		String[][] s = excel.read_excel();
//	}
//	
//	@Factory(dataProvider = "ex")
//	public Object[] createInstance(String e, String p) {
//		return new Object[] { new NewTest1()};
//	}
}
