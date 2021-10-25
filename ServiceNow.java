package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notification");
	WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver(options);				
			driver.get("https://dev106162.service-now.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
			driver.findElement(By.xpath("//label[text()='User name']/following-sibling::input")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("ahCaPjcWFO16");
			driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
			driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
			driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
			
			driver.switchTo().defaultContent();
			Set<String> windowHandles = driver.getWindowHandles();
			
			List<String> caller = new ArrayList<String>(windowHandles);
			driver.switchTo().window(caller.get(1));
			driver.findElement(By.linkText("Abel Tuter")).click();
			driver.switchTo().window(caller.get(0));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("gsft_main");
			String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
			System.out.println(text);
			driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("description");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(text + Keys.ENTER);
			//driver.switchTo().defaultContent();
			String tagName = driver.findElement(By.xpath("(//tbody[@class='list2_body']//a)[2]")).getText();
				if (tagName.equalsIgnoreCase(text)) {
					System.out.println("incident created");
				}
				else {
					System.out.println("incident not created");
				}
			
			
}
}
