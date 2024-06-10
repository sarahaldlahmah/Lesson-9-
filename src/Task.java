import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {

	WebDriver driver = new ChromeDriver();
	String myURL = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";
	
@BeforeTest 
public void mySetup () {
	driver.get(myURL);
	driver.manage().window().maximize();
	WebElement myUserName = driver.findElement(By.id("user-name"));
	 myUserName.sendKeys(userName);
	WebElement myPassword = driver.findElement(By.id("password"));
	 myPassword.sendKeys(password);
	WebElement login = driver.findElement(By.id("login-button")) ; 
	login.click();

	
}

@Test 
public void addEveryItemabove15 () {
	
	List <WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));
	List <WebElement> myPrices = driver.findElements(By.className("inventory_item_price"));

	
	//double ConvertedPrice =Double.parseDouble(Myprices.getFirst().getText().replace("$", ""));
    for (int i =0; i< myAddToCartButtons.size() ; i++) {
    String thePrice = 	myPrices.get(i).getText();
    String thePriceWithoutTheSign = thePrice.replace("$", "");
    double theConvertedPrice = Double.parseDouble (thePriceWithoutTheSign);
    if (theConvertedPrice > 15) 
    {
    	myAddToCartButtons.get(i).click();
    	
    }
    
    	
    	
    }
	
	
}
	
}
