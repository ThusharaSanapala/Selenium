import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		String congfile= "src//config.properties";
		BufferedReader reader = new BufferedReader(new FileReader(congfile));
		Properties prop = new Properties();
		prop.load(reader);
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='u_0_b']")).click();
		driver.close();

	}

}
