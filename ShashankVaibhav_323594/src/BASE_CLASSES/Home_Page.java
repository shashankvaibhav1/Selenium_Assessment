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

public class Home_Page {
	WebDriver dr;
	WebDriverWait wait;
	public Home_Page(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	@FindBy(xpath="//form[@name = 'products_search']/table[1]/tbody/tr/th")	
	WebElement text;
	
	@FindBy(xpath="//select[@name='category_id']")		//*[contains(text(),'')]
	WebElement cat_id;
	
	@FindBy(xpath="//input[@name = 's_keyword']")		//*[contains(text(),'')]
	WebElement cat_name;
	
	@FindBy(xpath="//input[@name='DoSearch']")		//*[contains(text(),'')]
	WebElement clk_btn;
	
	public String getText() {
		return text.getText();
	}
	public void setCategoryId(String cat) {
		cat_id.findElement(By.xpath("//*[contains(text(),'"+cat+"')]")).click();
	}
	public void setCategoryName(String cat) {
		cat_name.sendKeys(cat);
	}
	public void clk_bttn() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(clk_btn));
		clk_btn.click();
	}
}
