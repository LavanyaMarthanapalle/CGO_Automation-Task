package testcases;


import org.testng.annotations.Test;

import org.testng.AssertJUnit;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase_001 {
	public WebDriver driver;
	public String fname;
	public String lname;
	public WebDriverWait wait;
	public String heading;
	public String color;
	public String optionValueForSize;
	public String cost;

		

  @BeforeClass
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\q1035564\\Documents\\My documents\\SeleniumJars\\chromedriver_win32 (1)\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
  }
		
  @Test (priority=1)
  public void clickonRegisterForEmail() {
	  
	  driver.findElement(By.className("login")).click();
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("email_create"));
		name.sendKeys("wr312as0@gmail.com");
		driver.findElement(By.name("SubmitCreate")).click();
  }
  
  @Test(priority=2)
  public void registrationProces() {
	  wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstname']"))).sendKeys("Lavanya");
		//driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		//driver.findElement(By.xpath("//input[@id='firstname']"));
		fname="Lavanya";
		lname="Paladi";
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys(fname);
		
		//System.out.println(driver.findElement(By.xpath("//input[@name='customer_firstname']")).getText());
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys(lname);
		//String text = driver.findElement(By.xpath("//input[@name='customer_firstname']")).getText();
		System.out.println(fname);
		driver.findElement(By.name("lastname")).sendKeys("Paladi");
		driver.findElement(By.name("passwd")).sendKeys("a@qwe");
		driver.findElement(By.name("address1")).sendKeys("Bangalore");
		driver.findElement(By.name("city")).sendKeys("Bangalore");
		//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//name[@id='id_state']")));
       Select s = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
       s.selectByValue("14");
		driver.findElement(By.name("postcode")).sendKeys("49976");
      Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
      s.selectByValue("21");
		driver.findElement(By.name("phone_mobile")).sendKeys("1234567890");
		driver.findElement(By.name("alias")).sendKeys("ABCD");
		driver.findElement(By.name("submitAccount")).click();

  }
@Test(priority=3)
public void validateHomePageforName() {
	 String fullname = fname.concat(" ").concat(lname);
	 String nameOnHomepage = driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
	 AssertJUnit.assertEquals(fullname, nameOnHomepage);
}
@Test(priority=4)
public void navigateToHomePage() {
	driver.findElement(By.xpath("//a[@title='Home']")).click();
	}

@Test(priority=5)
public void addProducttoCart() throws InterruptedException {
	  wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='product_img_link']/img)[2]"))); 
	//click on the product
	WebElement element = driver.findElement(By.xpath("(//a[@class='product-name'])[2]")); 
	Actions actions = new Actions(driver); 
	actions.moveToElement(element).click().perform();
	Thread.sleep(3000);
	//driver.switchTo().alert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/*[@itemprop='name']"))); 
	//driver.findElement(By.xpath("(//a[@class='product_img_link']/img)[2]")).click();
	heading = driver.findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/*[@itemprop='name']")).getText();
	System.out.println(heading);
	//get color
	color = driver.findElement(By.xpath("//li[@class='selected']/a")).getAttribute("name");
	System.out.println(color);
	//getting the size
	Select size= new Select(driver.findElement(By.xpath("//select[@name='group_1']")));
	WebElement option = size.getFirstSelectedOption();
	optionValueForSize = option.getText();
	System.out.println(optionValueForSize);
	//price of the item
	cost = driver.findElement(By.xpath("//span[@itemprop='price']")).getText();
	System.out.println(cost);

    //adding to cart
	driver.findElement(By.xpath("//button[@name='Submit']")).click();	
}

@Test(priority=6)
public void processingOrder() throws InterruptedException {
	Thread.sleep(6000);
	//WebElement productWindow = driver.findElement(By.xpath("//div[@class='clearfix']"));
	//WebElement productWindow = driver.findElement(By.xpath("	layer_cart_cart col-xs-12 col-md-6"));

	//driver.switchTo().frame(productWindow);
	//driver.findElement(By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[4]/a")).click();
	//driver.switchTo().frame(productWindow);
	driver.findElement(By.xpath(".//a[contains(@title,'Proceed to checkout')]")).click();
    //Navigate till Payment page
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@name='processAddress']")).click();
	//Agreeing to the T&C
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
}

@Test(priority=7)
public void validatingProductDetailsOnPaymentPage() {
	
	//validating product name
	String productName = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[2]/p/a")).getText();
    Assert.assertEquals(heading, productName); 
    //validating product color and size
    String colorAndSize = "Color : ";
    colorAndSize = colorAndSize.concat(color).concat(", Size : ").concat(optionValueForSize);
	String productColorAndSize = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[2]/small/a")).getText();
    Assert.assertEquals(colorAndSize, productColorAndSize);
    //validating cost
    String productCost = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[4]/span/span")).getText();
    Assert.assertEquals(cost, productCost);
}



}

	  
  

