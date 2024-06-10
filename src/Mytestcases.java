import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases {

	WebDriver driver = new ChromeDriver();
	String myURL = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";
	
	
@BeforeTest 
public void mySetup () {
	
	driver.get(myURL);
	driver.manage().window().maximize();
//	driver.findElement(By.id("user-name")).sendKeys(userName);
//	driver.findElement(By.id("password")).sendKeys(password);
//	driver.findElement(By.id("login-button")).click();
//	
}
		
@Test (priority = 1)

public void myFirstTest () {

WebElement myUserName = driver.findElement(By.id("user-name"));
 myUserName.sendKeys(userName);
WebElement myPassword = driver.findElement(By.id("password"));
 myPassword.sendKeys(password);
WebElement login = driver.findElement(By.id("login-button")) ; 
login.click();
}


@Test (priority = 2, enabled = false) 
public void addAllItems () {
	
	List <WebElement> allAddButtons = driver.findElements(By.className("btn"));
	for (int i= 0 ; i< allAddButtons.size();i++ ) {
		allAddButtons.get(i).click();
		
	}
}
	
	@Test (priority = 3 , enabled= false) 
	public void addOneItemandSkipTheNext () {
		
		List <WebElement> allAddButtons = driver.findElements(By.className("btn"));
		for (int i= 0 ; i< allAddButtons.size();i++ ) {
			if (i ==2) {
			continue ;
			}
			allAddButtons.get(i).click();

			}
		
			 
			 }
	
	@Test (priority = 4 , enabled= true) 
	public void findAllElementsThaHasTheWordLabs () {
		
		List <WebElement> itemsNames = driver.findElements(By.className("inventory_item_name"));
		List <WebElement> allAddButtons = driver.findElements(By.className("btn"));
		for (int i= 0 ; i< itemsNames.size();i++ ) {
			
			String thename = itemsNames.get(i).getText();
			if (thename.contains("Labs")) {
				continue;
			}
			allAddButtons.get(i).click();
			}
		
			 
			 }
	
	
}