package demo.webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

@Component
public class CreateFireFoxWebDriver {
	
	public WebDriver buildFireFoxWebDriver() {
		// geckodriver path 
		String path = "D:/auxiliary/seleniumWebDriver/geckodriver.exe";
		String driverType = "webdriver.gecko.driver";
		System.setProperty(driverType, path);
		FirefoxOptions options = new FirefoxOptions();
		
		// options.addArguments("--headless"); // 如有需要(Linux模拟环境下), 指定"无头模式", 则不出现浏览器窗口

		FirefoxDriver driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // 指定加载等待时长上限, 此处为20秒
		driver.manage().window().maximize(); // 窗口自动最大化
		return driver;
	}
	
}
