package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver(options);				
				driver.get("http://leaftaps.com/opentaps/control/login");
				WebElement elelogin=driver.findElement(By.id("username"));
				WebElement elepass=driver.findElement(By.id("password"));
				elelogin.sendKeys("Demosalesmanager");
				elepass.sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
				Set<String> windowHandlesSet=driver.getWindowHandles();
				List<String> windowlist=new ArrayList<String>(windowHandlesSet);
				driver.switchTo().window(windowlist.get(1));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
				Thread.sleep(100);
				driver.switchTo().window(windowlist.get(0));
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				Set<String> windowHandlesSet1=driver.getWindowHandles();
				List<String> windowlist1=new ArrayList<String>(windowHandlesSet1);
				driver.switchTo().window(windowlist1.get(1));			
				driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
				driver.switchTo().window(windowlist1.get(0));
				driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
				driver.switchTo().alert().accept();
				String title = driver.getTitle();
				if (title.contains("Contact")) {
					System.out.println(title);}
					else {System.out.println(title);
						System.out.println("title not displayed");
					}
					
				}
				
				
				
	}


