package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    By sideMenuBtn=By.id("react-burger-menu-btn");


    public LoginPage clickLoginPage(){
        return new LoginPage(driver);
    }
    public ProductsPage clickProductPage(){
        return new ProductsPage(driver);
    }
    public SideMenuPage clickSideMenuPage(){
        driver.findElement(sideMenuBtn).click();
        return new SideMenuPage(driver);
    }

}
