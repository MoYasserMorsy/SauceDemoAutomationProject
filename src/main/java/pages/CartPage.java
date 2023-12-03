package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    CartPage(WebDriver driver){
        this.driver=driver;
    }

    By removeItemBtn=By.id("remove-sauce-labs-backpack");
    By addedItem=By.xpath("//div[@class='inventory_item_name']");
    By checkoutBtn=By.id("checkout");
    By firstName=By.id("first-name");
    By lastName=By.id("last-name");
    By postalCode=By.id("postal-code");
    By continueBtn=By.id("continue");
    By finishBtn=By.id("finish");
    By finishOrderText=By.xpath("//h2[@class='complete-header']");
    By backHomeBtn=By.id("back-to-products");
    By homePageAssert=By.xpath("//span[@class='title']");



    public void removeItem(){
        driver.findElement(removeItemBtn).click();
    }
    public String getTextAddedItem(){
        return driver.findElement(addedItem).getText();
    }
    private void clickCheckout(){
        driver.findElement(checkoutBtn).click();
    }
    public void fillCheckout(String firstname,String lastname, String zipCode){
        clickCheckout();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(postalCode).sendKeys(zipCode);
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();


    }
    public String getTextFinishOrderPage(){
        return driver.findElement(finishOrderText).getText();
    }
    public String BackToHomePage(){
        driver.findElement(backHomeBtn).click();
        return driver.findElement(homePageAssert).getText();
    }




}
