/*
 * Name: Shashank Vaibhav
 * Emp.Id: 323594
 */
package BASE_CLASSES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopping_Cart {
	WebDriver dr;
	WebDriverWait wait;
	public Shopping_Cart(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td/a[1]")	
	WebElement home;
	
	public void clk_product() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
	}
	
	@FindBy(xpath="//form[@name='store_shopping']/table[2]/tbody")	
	WebElement product_name;
	
	public String get_product_name(String pname) {
		return product_name.findElement(By.xpath("//*[contains(text(),'"+pname+"')]")).getText();
	}
	
	@FindBy(xpath="//form[@name='store_shopping']/table[2]/tbody")	
	WebElement product_price;
	
	public String get_product_price(String price) {
		return product_price.findElement(By.xpath("//*[contains(text(),'"+price+"')]")).getText();
	}
}
