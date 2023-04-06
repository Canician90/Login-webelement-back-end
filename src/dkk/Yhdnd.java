package dkk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Yhdnd {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://gcreddy.com/project/admin/login.php");
		
		
		driver.findElement(By.linkText("Online Catalog")).click();
		Thread.sleep(2000);
		String url1 = driver.getCurrentUrl();
		//System.out.println(url1);

		if (url1.equals("http://gcreddy.com/project/")) {
		System.out.println("Before Login – Page is redirecting from admin to user interface – Passed");
		}
		else {
		System.out.println("Before Login – Page is Not redirecting from admin to user interface – Failed");
		}

		driver.navigate().back();
		driver.findElement(By.name("username")).sendKeys("gcreddy");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("Temp@2020");
		Thread.sleep(1000);
		driver.findElement(By.id("tdb1")).click();
		Thread.sleep(2000);
		String url2 = driver.getCurrentUrl();

		if (url2.equals("http://gcreddy.com/project/admin/index.php")) {
		driver.findElement(By.linkText("Online Catalog")).click();
		}

		String url3 = driver.getCurrentUrl();
		//System.out.println(url3);

		if (url3.equals("http://gcreddy.com/project/")) {
		System.out.println("After Login – Page is redirecting from admin to user interface – Passed");
		}
		else {
		System.out.println("After Login – Page is Not redirecting from admin to user interface – Failed");
		}
		driver.close();
		}
		}
