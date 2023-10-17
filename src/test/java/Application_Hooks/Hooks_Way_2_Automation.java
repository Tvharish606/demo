package Application_Hooks;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks_Way_2_Automation 
{
	WebDriver driver;
	@BeforeClass
	public void Appliction_Start()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(02000);
		driver.quit();
	}
}
