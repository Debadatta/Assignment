package PageFactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(id="email")

    WebElement emailAddress;

    @FindBy(name="passwd")

    WebElement password;    

    @FindBy(id="SubmitLogin")

    WebElement signInButton;

    

    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set email in textbox

    public void setEmailAddress(String strEmail){

        emailAddress.sendKeys(strEmail);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    	password.sendKeys(strPassword);

    }

    //Click on login button

    public void clickSignInButton(){

            signInButton.click();

    }  

    

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToApplication(String strEmail, String strPasword){

        //Fill email address

        this.setEmailAddress(strEmail);

        //Fill password

        this.setPassword(strPasword);

        //Click SignIn Button

        this.clickSignInButton();           

    }

}