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

public class Search_Results_Page {
	WebDriver dr;
	WebDriverWait wait;
	public Search_Results_Page(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	@FindBy(xpath="/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/b/a")	
	WebElement product;
	
	public void clk_product() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();
	}
}
