/*
 * Name: Shashank Vaibhav
 * Emp.Id: 323594
 */
package BASE_CLASSES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Detail_Page {
	WebDriver dr;
	WebDriverWait wait;
	public Product_Detail_Page(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//input[@name='quantity']")		//*[contains(text(),'')]
	WebElement quantity;
	
	@FindBy(xpath="//input[@name='Insert1']")		//*[contains(text(),'')]
	WebElement clk_btn;
	
	public void setQuantity(String quant) {
		quantity.clear();
		quantity.sendKeys(quant);
	}
	
	public void clk_bttn() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(clk_btn));
		clk_btn.click();
	}
}
