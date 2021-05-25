package objectReopUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollHomePage {


	public ScrollHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='mousehover']")
	private WebElement mouseHover;
	
	public WebElement getMouseHover(){
		return mouseHover;
	}
}
