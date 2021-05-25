import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import genericlib.ExcelUtility;
import genericlib.PathConstants;
import genericlib.WebDriverUtlitiy;
import objectReopUtlity.HomePage;

//@Listeners(genericlib.ListnerImplementation.class)
public class TestHomePage extends BaseClass{
	
	
	
		
	@Test(groups="smoke")
	public void Test1() throws InterruptedException{
		HomePage home=new HomePage(driver);
		home.clickOnRadioButton1();
		
	}
	
	//TestBox
	@Test
	public void testbox() throws Throwable{
		HomePage home=new HomePage(driver);
		 ExcelUtility excel=new ExcelUtility();
		String excelPath=PathConstants.ExcelPath;
		 String text = excel.readingData(excelPath, "Sheet", 0, 0);
		home.getTextBox().sendKeys(text);
	
				
	}
	
	//dropdown
	@Test
	public void SelectDropDown() throws Throwable{
		HomePage home=new HomePage(driver);
		 WebDriverUtlitiy web=new WebDriverUtlitiy();
		WebElement ele = home.getDropdown();
		web.DropDown(ele, "Option1");
		Thread.sleep(2000);
	}
	

}
