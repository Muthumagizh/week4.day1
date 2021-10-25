package Week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.Alert;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leafground.com/pages/Alert.html");
	driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Alert alert=driver.switchTo().alert();
	
	String text = alert.getText();
	System.out.println(text);
	alert.accept();
	
	driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Alert alert1=driver.switchTo().alert();
	
	String text1 = alert1.getText();
	System.out.println(text1);
	alert1.accept();
	
	driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Alert alert11=driver.switchTo().alert();
	
	alert11.sendKeys("Muthu");
	
	alert11.accept();
	
	
	
	
}
}
