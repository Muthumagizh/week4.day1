package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement4Frames {
public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notification");
	WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver(options);				
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("frame1");
	driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input[1]")).sendKeys("Topic");
	driver.switchTo().frame("frame3");
	driver.findElement(By.xpath("//input[@id='a']")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frame2");
	WebElement dropdwnframe = driver.findElement(By.xpath("//select[@class='col-lg-3']"));
	Select select=new Select(dropdwnframe);
	select.selectByValue("avatar");
	
}
}
