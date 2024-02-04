package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideMenuPage {
    WebDriver driver;
    SideMenuPage(WebDriver driver){
        this.driver=driver;
    }
    By allItemsBtn=By.id("inventory_sidebar_link");
    By aboutBtn=By.id("about_sidebar_link");
    By logoutBtn=By.id("logout_sidebar_link");
    By resetBtn=By.id("reset_sidebar_link");
    By aboutTextPage=By.xpath("(//button[@type='button'])[15]");
    By afterLogout=By.xpath("//*[@id=\"login_credentials\"]/h4");


    public void explicitWait(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));

    }
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public String getTextByScrollAbout(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return  driver.findElement(aboutTextPage).getText();
    }
    public String getTextLogoutPage(){
        return driver.findElement(afterLogout).getText();
    }
    public void allItems(){
        //explicitWait(allItemsBtn);
        implicitWait();
        driver.findElement(allItemsBtn).click();

    }
    public void aboutApp(){
        //explicitWait(aboutBtn);
        implicitWait();
        driver.findElement(aboutBtn).click();
        getTextByScrollAbout();

    }
    public void logout(){
        //explicitWait(logoutBtn);
        implicitWait();
        driver.findElement(logoutBtn).click();
        getTextLogoutPage();

    }
    public void resetAppState(){
        //explicitWait(resetBtn);
        implicitWait();
        driver.findElement(resetBtn).click();

    }
}
