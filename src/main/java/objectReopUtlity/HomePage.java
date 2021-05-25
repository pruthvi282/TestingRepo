package objectReopUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@value='radio1']")
	private WebElement radioButtin1;

	public WebElement getRadioButtin1() {
		return radioButtin1;
	}

	public void clickOnRadioButton1(){
		radioButtin1.click();
	}

	@FindBy(xpath="//input[@id='autocomplete']")
	private WebElement TextBox;

	public WebElement getTextBox() {
		return TextBox;
	}
	
	@FindBy(xpath="//select[@id='dropdown-class-example']")
	private WebElement dropdown;

	public WebElement getDropdown() {
		return dropdown;
	}
	
	
	@FindBy(xpath="//button[@id='openwindow']")
	private WebElement OpenWindow;

	public WebElement getOpenWindow() {
		return OpenWindow;
	}
	
	@FindBy(xpath="//input[@placeholder='Enter your Email']")
	private WebElement PlaceHolder;

	public WebElement getPlaceHolder() {
		return PlaceHolder;
	}
	
	
}
