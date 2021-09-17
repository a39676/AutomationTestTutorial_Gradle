package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.webDriver.CreateChromeWebDriver;
import demo.webDriver.CreateFireFoxWebDriver;

@Controller
@RequestMapping(value = "/test")
public class DemoController {

	// 让 Spring Boot 管理, 在需要时创建 CreateFireFoxWebDriver 实例
	@Autowired
	private CreateFireFoxWebDriver fireFoxDriver;
	@Autowired
	private CreateChromeWebDriver chromeDriver;

	@GetMapping(value = "/createFireFox")
	@ResponseBody
	public String testWithFireFox() {
		WebDriver driver = fireFoxDriver.buildFireFoxWebDriver();
		driver.get("http://zhang3.xyz"); // 访问 zhang3.xyz

		WebElement link = driver.findElement(By.xpath("//*[contains(text(), 'UI自动化_环境搭建')]")); // 查找"UI自动化_环境搭建" 的链接

		link.click(); // 点击

		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit(); // 退出浏览器

		return "Done";
	}
	
	@GetMapping(value = "/createChrome")
	@ResponseBody
	public String testWithChrome() {
		WebDriver driver = chromeDriver.buildFireFoxWebDriver();
		driver.get("http://zhang3.xyz"); // 访问 zhang3.xyz

		WebElement link = driver.findElement(By.xpath("//*[contains(text(), 'UI自动化_环境搭建')]")); // 查找"UI自动化_环境搭建" 的链接

		link.click(); // 点击

		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit(); // 退出浏览器

		return "Done";
	}
}
