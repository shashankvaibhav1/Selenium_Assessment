/*
 * Name: Shashank Vaibhav
 * Emp.Id: 323594
 */

package TESTNG_TESTS;

import org.testng.annotations.Test;

import BASE_CLASSES.*;
import UTILITIES.EXCEL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest1 {
	WebDriver dr;
	Home_Page hp;
	Search_Results_Page srp;
	Product_Detail_Page pdp;
	Shopping_Cart sc;
	EXCEL excel;
	ArrayList<ArrayList> file1;
	ArrayList<ArrayList> file2;
	Logger log;
	@BeforeTest
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_version_75.exe");
		dr = new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Default.php");
		hp = new Home_Page(dr);
		srp = new Search_Results_Page(dr);
		pdp = new Product_Detail_Page(dr);
		sc = new Shopping_Cart(dr);
		excel = new EXCEL();
		file1 = excel.read_excel();
		file2 = excel.verify_excel();
		log = log.getLogger("devpinoyLogger");
		log.info("======================================================");	
		log.info("TEST CASE");	
		log.info("======================================================");	
	}
	@Test(priority=1)
	public void verifyHomeTitle() {
		String expected = "Online Bookstore";
		String actual = dr.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("verifyHomeTitle() is invoked");
	}
	
	@Test(priority=2)
	public void verifyHomeText() {
		String expected = "Search Products";
		String actual = hp.getText();
		Assert.assertEquals(actual, expected);
		log.info("verifyHomeText() is invoked");
	}
	@Test(priority=3)
	public void search_product() {
		String cat_id = file1.get(0).get(0).toString();
		String cat_name = file1.get(0).get(1).toString();
		hp.setCategoryId(cat_id);
		hp.setCategoryName(cat_name);
		hp.clk_bttn();
		log.info("search_product() is invoked");
	}
	@Test(priority=4)
	public void verifySearchTitle() {
		String expected = "SearchResults";
		String actual = dr.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("verifySearchTitle() is invoked");
	}
	@Test(priority=5)
	public void clickProduct() {
		srp.clk_product();
		log.info("clickProduct() is invoked");
	}
	@Test(priority=6)
	public void verifyProductTitle() {
		String expected = "ProductDetail";
		String actual = dr.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("verifyProductTitle() is invoked");
	}
	@Test(priority=7)
	public void productDetails() {
		String quant = file1.get(0).get(2).toString();
		pdp.setQuantity(quant);
		pdp.clk_bttn();
		log.info("productDetails() is invoked");
	}
	@Test(priority=8)
	public void anotherProduct() {
		sc.clk_product();
		String cat_id = file1.get(1).get(0).toString();
		String cat_name = file1.get(1).get(1).toString();
		hp.setCategoryId(cat_id);
		hp.setCategoryName(cat_name);
		hp.clk_bttn();
		srp.clk_product();
		String quant = file1.get(1).get(2).toString();
		pdp.setQuantity(quant);
		pdp.clk_bttn();
		log.info("anotherProduct() is invoked");
	}
	
	@AfterClass
	public void afterClass() {
		dr.quit();
		log.info("======================================================");
	}

}
