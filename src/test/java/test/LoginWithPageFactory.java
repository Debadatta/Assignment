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
import Lib.Util;

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
    	Util util = new Util();
    	Float price;
    	 objHomePage = new HomePage(driver);
    	 objHomePage.clickSignInButton();

    	 //Create Login Page object

    	 objLogin = new LoginPage(driver);
    	 objLogin.loginToApplication("jetblue@grr.la", "jetblue");

    	 // go the next page
    	 
    	 objMyAccountPage = new MyAccountPage(driver);
    	 util.waitForElement();
    	 objMyAccountPage.clickTshirtsMenu();
    	 util.waitForElement();
    	 util.scrollDown(driver);
    	 objMyAccountPage.clickOnProduct();
    	 util.scrollDown(driver);
    	 objMyAccountPage.clickOnAddToCart();
    	 Thread.sleep(5000);
    	 Assert.assertTrue(objMyAccountPage.getProductAddedMessage().toLowerCase().contains("product successfully added to your shopping cart"));
    	 Assert.assertTrue(objMyAccountPage.getProductTitle().contains("Faded Short Sleeve T-shirts"));
    	 Assert.assertTrue(objMyAccountPage.getProductAttr().contains("Orange, S"));
    	 price = (float) (16.51 * Integer.parseInt(objMyAccountPage.getProductQty()));
    	 Assert.assertTrue(objMyAccountPage.getProductPrice().toString().equals("$"+Float.toString(price)));
    	 objMyAccountPage.clickOnproceedToCheckoutButton();
    	 	 
    	
    	 

    }
    
    @AfterTest

    public void teardown(){
    	driver.close();
    }

}
