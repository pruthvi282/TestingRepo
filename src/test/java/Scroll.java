import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import genericlib.WebDriverUtlitiy;
import objectReopUtlity.HomePage;
import objectReopUtlity.ScrollHomePage;

public class Scroll extends BaseClass {

	@Test(groups="smoke")
	public void MouseHover() throws InterruptedException{
		ScrollHomePage scroll=new ScrollHomePage(driver);
		WebDriverUtlitiy web=new WebDriverUtlitiy();
		WebElement ele = scroll.getMouseHover();
		
	 Point loc = ele.getLocation();
	 int x = loc.getX();
	 int y=loc.getY();
		
	
		web.ScrollDown(driver, x,y);
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		web.MouseActions(driver, ele);
		
		driver.findElement(By.xpath("//a[contains(text(),'Top')]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void window() throws InterruptedException{
		HomePage home=new HomePage(driver);
		WebDriverUtlitiy web=new WebDriverUtlitiy();
		
		home.getOpenWindow().click();
		web.SwitchBrowser(driver, "QA Click Academy");
		WebElement ele1 = home.getPlaceHolder();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele1));
		ele1.sendKeys("my.emal.com");
		Thread.sleep(3000);
		
		
		
	}
}
