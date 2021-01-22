package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;

public class LoginWithPageFactory {

	String driverPath = "D:\\Project\\JavaMaven\\chromedriver.exe";
    
    WebDriver driver;

    LoginPage objLogin;

    HomePage objHomePage; 
    MyAccountPage objMyAccountPage;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

    }

    /**

     * This test go to http://automationpractice.com/index.php

     * Login to application

     * Verify the home page using Dashboard message
     * @throws InterruptedException 

     */

    @Test(priority=0)

    public void test_add_product_to_cart() throws InterruptedException{
    	
    	Float price;
    	 objHomePage = new HomePage(driver);
    	 objHomePage.clickSignInButton();

    	 //Create Login Page object

    	 objLogin = new LoginPage(driver);
    	 objLogin.loginToApplication("jetblue@grr.la", "jetblue");

    	 // go the next page
    	 
    	 objMyAccountPage = new MyAccountPage(driver);
    	 Thread.sleep(5);
    	 objMyAccountPage.clickTshirtsMenu();
    	 Thread.sleep(5);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0,500)");
    	 objMyAccountPage.clickOnProduct();
    	 js.executeScript("window.scrollBy(0,500)");
    	 objMyAccountPage.clickOnAddToCart();
    	 Assert.assertTrue(objMyAccountPage.getProductAddedMessage().toLowerCase().contains("Product successfully added to your shopping cart"));
    	 Assert.assertTrue(objMyAccountPage.getProductTitle().toLowerCase().contains("Faded Short Sleeve T-shirts"));
    	 Assert.assertTrue(objMyAccountPage.getProductAttr().toLowerCase().contains("Orange, S"));
    	 price = (float) (16.52 * Integer.parseInt(objMyAccountPage.getProductQty()));
    	 Assert.assertTrue(objMyAccountPage.getProductPrice().toLowerCase().contains("$"+Float.toString(price)));
    	 objMyAccountPage.clickOnproceedToCheckoutButton();
    	 js.executeScript("window.scrollBy(0,500)");
    	 
    	
    	 

    }
    
    @AfterTest

    public void teardown(){
    	driver.close();
    }

}
