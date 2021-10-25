package Week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleNotification {
public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notification");
	WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver(options);
			
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			driver.switchTo().alert().accept();
			String text = driver.findElement(By.id("demo")).getText();
			if(text.contains("OK"))
			{System.out.println("OK pressed");}
			else if((text.contains("Cancel")))
					{System.out.println("Cancel pressed");}
			
			
	
}
}
