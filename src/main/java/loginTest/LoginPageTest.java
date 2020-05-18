package loginTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTest {
	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin");
	}

	@Test
	public void loginTest() {

		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name = 'login']")).click();

	}

	@Test
	public void addContactPage() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name = 'login']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(), 'CRM')]")).click();
		driver.findElement(By.xpath("//a[contains (text() , 'Add Contact')]")).click();
		Thread.sleep(2000);
		
		Random random = new Random();
		int rnd = random.nextInt(999);
		
		String enterName = "Afi" + rnd;
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys(enterName);
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techfios");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(rnd + "afi@gmail.com" );
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("1715 ");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("irving");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Texas");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("75287");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
