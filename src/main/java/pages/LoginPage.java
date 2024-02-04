package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    By userNameField=By.id("user-name");
    By passwordField=By.id("password");
    By submitBtn=By.id("login-button");
    By productsHome=By.xpath("//span[@class='title']");

    public void setUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public String getText(){
        return  driver.findElement(productsHome).getText();
    }
    public ProductsPage clickSubmitLogin(){
        driver.findElement(submitBtn).click();
        return new ProductsPage(driver);
    }


}
