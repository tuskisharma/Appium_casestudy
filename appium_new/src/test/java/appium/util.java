package appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class util {
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	public static void passingValuesUsingJS(WebElement element, String message, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].value='" + message + "'", element);
	}
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
