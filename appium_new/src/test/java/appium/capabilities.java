package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class capabilities extends util{
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException 
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:/Users/tusha/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test(enabled=false)
	public void testcase() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		System.out.println("Hello Let’s do Appium");
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Moolyaed");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('ynAwRc q8U8x MBeuO oewGkc LeUQr htnRc')[1].scrollIntoView()");
	    driver.findElement(By.xpath("//*[text()='MoolyaEd | LinkedIn']")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		List<AndroidElement> li=driver.findElementsByTagName("a");
		System.out.println(li.size());
		for(int i=0;i<li.size();i++) {
			String str=li.get(i).getAttribute("href");
			System.out.println(str);
		}
		
		

}
	@Test
	public void orangehrm() throws InterruptedException {
		driver.get("https://www.google.com");
		WebElement   a= driver.findElement(By.xpath("//*[@class='gLFyf']"));
		Actions act = new Actions(driver);
		act.moveToElement(a).click().build().perform();
		act.sendKeys(a, "orangehrm").build().perform();
		act.sendKeys(a, Keys.ENTER).build().perform();
		Thread.sleep(3000);
		WebElement  t= driver.findElement(By.xpath("//*[text()='opensource-demo.orangehrmlive.com'][1]"));
		util.scrollIntoView(t, driver);
		util.clickElementByJS(t, driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']//i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Admin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down-fill')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		
		
	}
}
