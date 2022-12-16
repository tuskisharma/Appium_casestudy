package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;;

public class native_apps {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test(enabled = false,priority = 0)
	public void test() throws InterruptedException
	{
		System.out.println("native app");
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		driver.findElements(MobileBy.className("android.widget.TextView")).get(5).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.AccessibilityId("Play")).click();
		
		
	}
	@Test(enabled = false,priority = 1)
	public void test1() throws InterruptedException {
		driver.openNotifications();
		Thread.sleep(3000);
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(3).click();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		
	}
	@Test(enabled=false)
	public void tap_longpress() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(3000);
		AndroidElement tp=driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tp))).perform();
		Thread.sleep(3000);
		AndroidElement lp=driver.findElementByAndroidUIAutomator("text(\"Dog Names\")");
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("text(\"Sample action\")").click();
		}
	@Test(enabled = false)
	public void scroll() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Graphics")).click();
		Thread.sleep(3000);
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"MeasureText\"))").click();
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 Thread.sleep(3000);
		 driver.pressKey(new KeyEvent(AndroidKey.HOME));
		 Thread.sleep(3000);
		 driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		 Thread.sleep(3000);
		 driver.pressKey(new KeyEvent(AndroidKey.HOME));
		}
	@Test(enabled = false)
	public void swipe_actions() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		
		AndroidElement ele1=driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement ele2=driver.findElement(MobileBy.AccessibilityId("30"));
		TouchAction ta=new TouchAction(driver);
		Thread.sleep(3000);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
		
		
	}
	@Test(enabled = false)
	public void draganddrop() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement ele1=driver.findElements(MobileBy.className("android.view.View")).get(0);
		AndroidElement ele2=driver.findElements(MobileBy.className("android.view.View")).get(2);
		TouchAction ta=new TouchAction(driver);
		Thread.sleep(3000);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	}
	@Test(enabled = false)
	public void switchapp() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(555) 521-5554");
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("50% discount");
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("Send").click();
		Thread.sleep(3000);
		driver.activateApp("com.google.android.apps.messaging");
		Thread.sleep(3000);
		String    U= driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(U);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
	}
	@Test(enabled = true)
	public void task() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("3D Transition")).click();
		Thread.sleep(3000);
		TouchAction ta=new TouchAction(driver);
	    driver.findElementByAndroidUIAutomator("text(\"Lyon\")").click();
	    Thread.sleep(3000);
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("text(\"Livermore\")").click();
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("text(\"Tahoe Pier\")").click();
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("text(\"Lake Tahoe\")").click();
	    Thread.sleep(3000);
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("text(\"Grand Canyon\")").click();
	    Thread.sleep(3000);
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
	    driver.findElementByAndroidUIAutomator("text(\"Bodie\")").click();
	    Thread.sleep(3000);
	    driver.findElementById("io.appium.android.apis:id/picture").click();
	    Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(3000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"))").click();
        Thread.sleep(3000);
        AndroidElement   a= driver.findElementById("io.appium.android.apis:id/seek");
        ta.longPress(PointOption.point(535,241)).moveTo(PointOption.point(187, 250)).release().perform();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
  
       
        
		
		
		}
}
