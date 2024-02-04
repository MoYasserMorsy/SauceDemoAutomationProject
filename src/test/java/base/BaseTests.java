package base;

import Tests.LoginTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductsPage;
import pages.LoginPage;

public class BaseTests {
    private WebDriver driver;
    protected  HomePage homePage;
    protected  LoginPage loginPage;
    private   LoginTests loginTests ;
    Class<?> currentClass = this.getClass(); // Get the current class
    String username = "standard_user";
    String password = "secret_sauce";
    @BeforeClass
    public void setUp(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        homePage=new HomePage(driver);

    }
    @BeforeMethod
        public void testHomeValidLogin(){
        driver.get("https://www.saucedemo.com/");
        if(!currentClass.equals(LoginTests.class)){
            LoginPage loginPage=homePage.clickLoginPage();
            loginPage.setUserName(username);
            loginPage.setPassword(password);
              loginPage.clickSubmitLogin();
        }
        else{

        }

        }
    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
