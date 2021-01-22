package PageFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    
    @FindBy(className="login")
    WebElement signInLink;

    

    public HomePage(WebDriver driver){

        this.driver = driver;
        
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
   

	public void clickSignInButton(){
	
		signInLink.click();
	
	}

}
