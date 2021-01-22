package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")

    WebElement tshirtMenu;

    @FindBy(partialLinkText="Faded Short Sleeve T-shirts")
    WebElement productLink;    

    @FindBy(xpath="//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    @FindBy(partialLinkText="Proceed to checkout")
    WebElement proceedToCheckoutButton;
    
    @FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")    
    WebElement productAddedMessage;
    
    
    @FindBy(id="layer_cart_product_title")    
    WebElement cartProductTitle;
    
    @FindBy(id="layer_cart_product_attributes")    
    WebElement cartProductAttr;
    
    @FindBy(id="layer_cart_product_quantity")    
    WebElement cartProductQty;
        
    
    @FindBy(id="layer_cart_product_price")    
    WebElement cartProductPrice;

    public MyAccountPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public void clickTshirtsMenu() {
    	tshirtMenu.click();
    }

    public void clickOnProduct() {
    	productLink.click();
    }
    
    public void clickOnAddToCart() {
    	addToCartButton.click();
    }
    
    public void clickOnproceedToCheckoutButton() {
    	proceedToCheckoutButton.click();
    }
    
    public String getProductTitle( ) {    	
    	return cartProductTitle.getText();
    }
    
    public String getProductAttr( ) {    	
    	return cartProductAttr.getText();
    }
    
    public String getProductQty( ) {    	
    	return cartProductQty.getText();
    }
    
    public String getProductPrice( ) {    	
    	return cartProductPrice.getText();
    }
    
    public String getProductAddedMessage( ) {
    	return productAddedMessage.getText();
    }


}
