package Tests;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }
    LoginPage loginPage;
    @Test(dataProvider = "LoginData")
    public void testWithValidLogin(String username ,String password){
        loginPage=homePage.clickLoginPage();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmitLogin();
    }

}
