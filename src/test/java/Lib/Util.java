package Lib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Util {
	public void scrollDown(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   	 js.executeScript("window.scrollBy(0,500)");
	}
	
	public void waitForElement() throws InterruptedException {
		Thread.sleep(100);
	}
}
