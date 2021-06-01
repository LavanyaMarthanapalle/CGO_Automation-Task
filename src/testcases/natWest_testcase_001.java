package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class natWest_testcase_001 {		
	public WebDriver driver;
	public String fname;
	public String lname;
	public WebDriverWait wait;
	public String heading;
	public String color;
	public String optionValueForSize;
	public String cost;
	
    //launching the browser & launching the required URL
	@BeforeClass
	  public void launchBrowser() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\q1035564\\Documents\\My documents\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
	  }
		
	//Registration 
	  @Parameters({"runname"})
	  @Test (priority=1)
	  //providing data for parameters or variable at run time using parameter annotation & @optional method
	  public void clickonRegisterForEmail(@Optional("LavanyaNatwest@gmail.com") String runname) throws IOException {
		  
		  driver.findElement(By.className("login")).click();
			driver.manage().window().maximize();
			WebElement name = driver.findElement(By.id("email_create"));
			name.sendKeys(runname);
			driver.findElement(By.name("SubmitCreate")).click();
	  }
	
	 
	 //Providing the details during registration and complete the registration process.	  
	 @Test(priority=2)
	  public void registrationProces() throws IOException {
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
			
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\q1035564\\Documents\\My documents\\screenshot2.png"));
	  
	  }
	  
	
	/*@Test(priority=4)
	public void navigateToHomePage() {
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		}*/

	@Test(priority=4)
	public void navigatingtoTShirt() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]")).click();
		
	}
	@Test(priority=5)
	public void addProducttoCart() throws InterruptedException {
		  wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='product_img_link']/img)[1]"))); 
		//click on the product
		WebElement element = driver.findElement(By.xpath("(//a[@class='product-name'])[2]")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(element).click().perform();
		Thread.sleep(3000);
		//driver.switchTo().alert();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1"))); 
		//driver.findElement(By.xpath("(//a[@class='product_img_link']/img)[2]")).click();
		//heading = driver.findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/*[@itemprop='name']")).getText();
		heading = driver.findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1")).getText();

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
		Thread.sleep(1000);

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
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		Thread.sleep(3000);

	}

	@Test(priority=7)
	public void validatingProductDetailsOorderHistoryPage() throws InterruptedException {
		//navigating to My account
		driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
		Thread.sleep(1500);
		//Navigate to orders history page
		driver.findElement(By.xpath("//a[@title='Orders']")).click();
		Thread.sleep(800);

		//clicking on the order that we created
		driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr/td[1]")).click();
		//validating product name
		String productName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]/label")).getText();
	    String productduringAddtoCart = heading.concat(" - Color : ").concat(color).concat(", Size : ").concat(optionValueForSize);
		Assert.assertEquals(productduringAddtoCart, productName); 
		System.out.println(productduringAddtoCart);
	    /*//validating product color and size
	    String colorAndSize = "Color : ";
	    colorAndSize = colorAndSize.concat(color).concat(", Size : ").concat(optionValueForSize);
		String productColorAndSize = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[2]/small/a")).getText();
	    Assert.assertEquals(colorAndSize, productColorAndSize);*/
	    //validating cost
	    String productCost = driver.findElement(By.xpath("//table[@class='table table-bordered']/tfoot/tr[2]/td[2]/span")).getText();
	    Assert.assertEquals(cost, productCost);
	    
	} 
	
	
	 //Updating the Personal information (Firstname) under My Account 
	@Test(priority=8)
	
	public void updatingTheName() throws InterruptedException {
		//navigating to My account
				driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
				Thread.sleep(1500);
		String fnameupdate = "Lavanya123";
		driver.findElement(By.xpath("//a[@title='Information']")).click();
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys(fnameupdate);
		driver.findElement(By.xpath("//input[@name='old_passwd']")).sendKeys("a@qwe");
		driver.findElement(By.xpath("//button[@name='submitIdentity']")).click();
		
		} 
	
	/* @AfterClass
	  public void closingBrowser()
	  {
		  driver.close();
	  }*/

}
