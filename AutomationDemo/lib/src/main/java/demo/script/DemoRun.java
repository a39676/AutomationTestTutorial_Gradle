package demo.script;

import org.openqa.selenium.WebDriver;

import demo.webDriver.CreateChromeWebDriver;

public class DemoRun {

	public static void main(String[] args) {
		WebDriver driver = CreateChromeWebDriver.buildFireFoxWebDriver();
		// Http GET 方式访问 bing.com
		driver.get("http://bing.com");
		try {
			// 等待10秒
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		driver.quit();
	}
}
