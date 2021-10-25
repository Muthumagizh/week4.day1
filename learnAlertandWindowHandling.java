package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class learnAlertandWindowHandling {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver(options);				
				driver.get("https://www.irctc.co.in/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
	Set<String> windowHandlesSet=driver.getWindowHandles();
	List<String> windowlist=new ArrayList<String>(windowHandlesSet);
	driver.switchTo().window(windowlist.get(1));
	String text = driver.findElement(By.xpath("(//div[contains(@class,'block-nav-right d-none')]//a)[3]")).getText();
	System.out.println(text);
	driver.switchTo().window(windowlist.get(0));
	driver.close();
	}

}
