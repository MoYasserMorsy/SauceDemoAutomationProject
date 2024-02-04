package Tests;
import base.BaseTests;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
public class LoginTests extends BaseTests {
    //if you want to read data using data provider
    /*@DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }*/
    @DataProvider(name = "LoginData")
    public Object[][] provideLoginData() throws IOException, ParseException {
        JSONObject data = readDataFromJSON();
        JSONArray users = (JSONArray) data.get("users");
        Object[][] userData = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            userData[i][0] = user.get("username");
            userData[i][1] = user.get("password");
        }
        return userData;
    }
    public JSONObject readDataFromJSON() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/validLoginData.json");
        Object obj = jsonParser.parse(reader);
        return (JSONObject) obj;
    }
    LoginPage loginPage;
    @Test(dataProvider = "LoginData")
    public void testWithValidLogin(String username ,String password) {
        loginPage=homePage.clickLoginPage();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmitLogin();
    }


}
