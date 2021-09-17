package demo.webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class CreateChromeWebDriver {
	
	public WebDriver buildFireFoxWebDriver() {
		// chromedriver path 
		String path = "D:/auxiliary/seleniumWebDriver/chromedriver.exe";
		String driverType = "webdriver.chrome.driver";
		System.setProperty(driverType, path);
		ChromeOptions options = new ChromeOptions();
		
		// options.addArguments("--headless"); // 如有需要(Linux模拟环境下), 指定"无头模式", 则不出现浏览器窗口

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // 指定加载等待时长上限, 此处为20秒
		driver.manage().window().maximize(); // 窗口自动最大化
		return driver;
	}
	
}
