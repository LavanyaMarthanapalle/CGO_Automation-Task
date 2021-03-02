import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleTestApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\q1035564\\Documents\\My documents\\SeleniumJars\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		/*driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("email_create"));
		name.sendKeys("mar11@gmail.com");
		driver.findElement(By.name("SubmitCreate")).click();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstname']"))).sendKeys("Lavanya");
		//driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		//driver.findElement(By.xpath("//input[@id='firstname']"));
		String fname="Lavanya";
		String lName="Paladi";
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys(fname);
		
		//System.out.println(driver.findElement(By.xpath("//input[@name='customer_firstname']")).getText());
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys(lName);
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
		
//Home Page
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[2]")).click();
		String heading = driver.findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1")).getText();
		System.out.println(heading);
		//get color
		String color = driver.findElement(By.xpath("//li[@class='selected']/a")).getAttribute("name");
		System.out.println(color);
		//getting the size
		Select size= new Select(driver.findElement(By.xpath("//select[@name='group_1']")));
		WebElement option = size.getFirstSelectedOption();
		String optionValue = option.getText();
		//price of the item
		String cost = driver.findElement(By.xpath("//span[@itemprop='price']")).getText();
        //adding to cart
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		//Agreeing to the T&C
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();*/
 
	}

}
