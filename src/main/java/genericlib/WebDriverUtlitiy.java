package genericlib;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebDriverUtlitiy {
	
	JavaUtility jav=new JavaUtility();

	public void TakeScreenShot(String MethodName,WebDriver driver) throws Throwable{
		String date = jav.date();
		String current = date.replace(":", "_").replace(" ", "_");
		
		EventFiringWebDriver event=new EventFiringWebDriver(BaseClass.staticdriver);
		File src=event.getScreenshotAs(OutputType.FILE);
		File dst=new File("./ScreenShots "+MethodName+current+"/.jpeg");
		Files.copy(src, dst);
		
	}

	public void wait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * DropDown
	 */
	
	public void DropDown(WebElement element,String Text){
		Select sel=new Select(element);
		sel.selectByVisibleText(Text);;
	}
	
	public void DropDown(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	public void SwitchBrowser(WebDriver driver,String Title){
		Set<String> set = driver.getWindowHandles();
		for(String s:set){
		driver.switchTo().window(s);
		String	title=driver.getTitle();
			if(title.contains(Title)){
				break;
			}
		}
		
	}
	
	public void ScrollDown(WebDriver driver,int x,int y){
		JavascriptExecutor java=(JavascriptExecutor)driver;
		java.executeScript("window.scrollBy("+x+","+y+")");
	}

	public void MouseActions(WebDriver driver,WebElement ele){
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();;
		
	}
}
