package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybrid_apps {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(enabled = false)
	public void negativetest() {
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bhutan\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast=driver.findElement(MobileBy.xpath("//android.widget.Toast")).getText();
		System.out.println(toast);
	}
	@Test(enabled = true)
	public void positivetest() throws InterruptedException {
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bhutan\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("leo");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\").instance(0))"));
		Thread.sleep(3000);
		driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		int count=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/rvProductList")).size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String pn=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(pn);
			
			if(pn.equalsIgnoreCase("Jordan Lift Off")) {
				driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvCartProductList\")).scrollIntoView(new UiSelector().text(\"Jordan Lift Off\"))"));
		
		
		String p1=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		p1=p1.substring(1);
		
		Double firstproduct=Double.parseDouble(p1);
		System.out.println(firstproduct);
		
		String p2=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		p2=p2.substring(1);
		
		Double secondproduct=Double.parseDouble(p2);
		System.out.println(secondproduct);
		
		
		String p3=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(2).getText();
		p3=p3.substring(1);
		
		Double thirdproduct=Double.parseDouble(p3);
		System.out.println(thirdproduct);
		
		Double total=firstproduct+secondproduct+thirdproduct;
		System.out.println("Total of the three products is "+total);
		
		String t=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		t=t.substring(1);
		Double price=Double.parseDouble(t);
		if(total.equals(price)) {
			System.out.println("total price of the products and price displayed in cart matched");
		}
		else {
			System.out.println("total price of the products and price displayed in cart did not matched");
		}
	    Assert.assertEquals(total,price);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
	@Test(enabled = false)
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bhutan\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("leo");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))");
	    Thread.sleep(3000);
	    driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
	    Thread.sleep(3000);
	    driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    Thread.sleep(3000);
	    String   converse= driver.findElements(MobileBy.className("android.widget.TextView")).get(1).getText();
		System.out.println("name of the product is "+converse);
		String   converse2= driver.findElements(MobileBy.className("android.widget.TextView")).get(2).getText();
		System.out.println("price of the product is "+converse2);
		Thread.sleep(3000);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.className("android.widget.Button")).click();
	}
}
