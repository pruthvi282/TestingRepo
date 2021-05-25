package genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
FileUtility file=new FileUtility();
public WebDriver driver;
WebDriverUtlitiy web=new WebDriverUtlitiy();
public static  WebDriver staticdriver;

	@BeforeSuite(groups={"smokeTest"})
	public void connectDB(){
		
	}
	@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest"})
	public void OpenBrowser(String browser) throws Throwable{
		//String Browser = file.propertydata(PathConstants.PropertyPath,"browser");
		if(browser.equals("firefox")){
		driver= new FirefoxDriver();	
		}
		else{
			driver= new ChromeDriver();
		}
		String URL=file.propertydata(PathConstants.PropertyPath,"URL");
		driver.get(URL);
		web.wait(driver);
	}
	
	@BeforeMethod(groups={"smokeTest"})
	public void closeApp() throws Throwable{
	
	}

	@AfterClass(groups={"smokeTest"})
	public void closeBroswer(){
		driver.close();
	}

}

