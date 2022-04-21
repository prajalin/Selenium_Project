package qedge_march10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		Properties p = new Properties();
		p.load(new FileInputStream("Login.Properties"));
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("objreset"))).click();
		driver.findElement(By.xpath(p.getProperty("objusername"))).sendKeys(p.getProperty("usernamedata"));
		driver.findElement(By.xpath(p.getProperty("objpassword"))).sendKeys(p.getProperty("passworddata"));
		driver.findElement(By.xpath(p.getProperty("objlogin"))).sendKeys(Keys.ENTER);
		driver.close();
		
		

	}

}
