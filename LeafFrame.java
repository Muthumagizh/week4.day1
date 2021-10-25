package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafFrame {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver(options);				
				driver.get("http://leafground.com/pages/frame.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.switchTo().frame(driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]")));
				driver.findElement(By.id("Click")).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]")));
				driver.switchTo().frame("frame2");
				driver.findElement(By.id("Click1")).click();
				driver.switchTo().defaultContent();
				List<WebElement> frame=new ArrayList<WebElement>(driver.findElements(By.tagName("iframe")));
				int size = frame.size();
				System.out.println(size);
				
				
	}

}
