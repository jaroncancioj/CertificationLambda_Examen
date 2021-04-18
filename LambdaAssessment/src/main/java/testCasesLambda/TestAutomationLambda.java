package testCasesLambda;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAutomationLambda {

	public static void main(String[] args) throws InterruptedException {

//1. Start by opening LambdaTest Selenium Playground
		WebDriver driver;		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jroncancio\\eclipse-workspace\\drivers\\chromedriver.exe");//!!!!!!!	
		driver = new ChromeDriver();			
		driver.get("https://www.lambdatest.com/automation-demos/");
		driver.manage().window().maximize();		
		
		//Elements locators
		String 	cookiesLocator 	= ".cbtn.btn_close_ck",
				userLocator		= "username",
				pwdLocator		= "//input[@id='password']",
				loginLocator 	= "//button[contains(text(),'Login')]",
				toastLocator 	= ".toast.jam",
				emailLocator	= ".name-field #developer-name",
				populateLocator	= "input[value='Populate']",
				radioLocator	= "//input[@id='3months']",
				checkLocator	= ".checkbox input[name='delivery-time']",
				dropdownLocator	= "select[name='preferred-payment']",
				optionLocator	= "//option[contains(text(),'Cash on delivery')]",
				checkEnableLocator	= "tried-ecom",
				//sliderLocator	= "span[style='left: 88.8889%;']";
				//sliderLocator_	= "//div[contains(text(),'9')]";	
				sliderLocator	= ".sliderBar #slider",
				feedbackLocator = "textarea[name='comments']";

		//Form Data
		String 	user		= "lambda",
				pwd			= "lambda123",
				email		= "jroncancio@intergrupo.com",				
				feedback	= "";
		
		
		//close cookies alert
		driver.findElement(By.cssSelector(cookiesLocator)).click();
//2. Log in
		//type credentials and login
		driver.findElement(By.id(userLocator)).sendKeys(user);
		driver.findElement(By.xpath(pwdLocator)).sendKeys(pwd);
		driver.findElement(By.xpath(loginLocator)).click();

//2. mark the login test Passed once the login success toast disappears	
		WebElement Successfull =  driver.findElement(By.cssSelector(toastLocator));
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.attributeContains(Successfull, "style", "none"));
		String toastDisplay = Successfull.getAttribute("style");
				
		if (toastDisplay.equals("display: none;")) {
			System.out.println("Thank You Successully Login!! - LOGIN TEST PASSED -> style= "+ toastDisplay);
		}else if (toastDisplay.equals("display: block;")){
			{System.out.println("LOGIN TEST FAILED -> style= "+ toastDisplay); }	
		}else {System.out.println("Login Failed -> style= "+toastDisplay);}
		
//3. fill in your registered email address in the first field and click on populate		
		driver.findElement(By.cssSelector(emailLocator)).sendKeys(email);
		driver.findElement(By.cssSelector(populateLocator)).click();

//4. Engage with the alert pop-up	
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertPopUp = driver.switchTo().alert();
		Thread.sleep(2000);	
		alertPopUp.accept();
		
//5. Answer the remaining questions on the feedback form engaging with the radio buttons, checkboxes, and dropdown.
		//radio buttons
		driver.findElement(By.xpath(radioLocator)).click();
		//checkboxes
		driver.findElement(By.cssSelector(checkLocator)).click();		
		//dropdown
		driver.findElement(By.cssSelector(dropdownLocator)).click();
		driver.findElement(By.xpath(optionLocator)).click();
		
//6. Enable the rating scale and feedback text field from the respective checkbox
		driver.findElement(By.name(checkEnableLocator)).click();
		
//7. In the rating scale, set the ratings to 9 and assert if the selected position of the slider is as required	
		/*driver.findElement(By.xpath(sliderLocator)).click();
			
		WebElement sld =  driver.findElement(By.cssSelector(sliderLocator));
		Actions move = new Actions(driver);
		move.dragAndDropBy(sld,0,9).build().perform();//ERROR!!
		//?new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(sliderLocator))).click();
		System.out.println("pasó");*/
		
//Open https://www.lambdatest.com/selenium-automation page in a new	browser tab	
		 

		 
		 
		
		driver.findElement(By.cssSelector(feedbackLocator)).click();
		
		//Thread.sleep(3000);		
		//driver.close();
	}

}
