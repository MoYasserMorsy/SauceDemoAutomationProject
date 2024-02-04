package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By dropDownBtn = By.className("product_sort_container");
    By productContainer = By.id("inventory_container");
    By firstProduct=By.xpath("(//div[@class='inventory_item_name '])[1]");
    By addToCartBtn=By.id("add-to-cart-sauce-labs-backpack");
    By cartId=By.id("shopping_cart_container");

    public boolean isOnProductPage() {
        return driver.findElement(productContainer).isDisplayed();
    }
    public void selectFromDropDown(String valueSort){
        Select select=new Select(driver.findElement(dropDownBtn));
        select.selectByValue(valueSort);

    }
    public String getTextFirstOrder(){
        return driver.findElement(firstProduct).getText();

    }
    public void addItemToCart(){
        driver.findElement(addToCartBtn).click();
    }
    public CartPage clickCartPage(){
        addItemToCart();
        driver.findElement(cartId).click();
        return new CartPage(driver);
    }


}
