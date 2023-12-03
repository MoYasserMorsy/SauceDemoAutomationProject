package Tests;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SideMenuPage;

public class SideMenuTests extends BaseTests {
    SideMenuPage sideMenuPage;
    @Test
    public void DisplayAllItems() {
        sideMenuPage = homePage.clickSideMenuPage();
        sideMenuPage.allItems();
    }
    @Test
    public void AboutApp() {
        sideMenuPage = homePage.clickSideMenuPage();
        sideMenuPage.aboutApp();
        Assert.assertEquals(sideMenuPage.getTextByScrollAbout(),"Sign up","true about page");
    }
    @Test
    public void LogOut() {
        sideMenuPage = homePage.clickSideMenuPage();
        sideMenuPage.logout();
        Assert.assertEquals(sideMenuPage.getTextLogoutPage(),"Accepted usernames are:","true logout page");

    }
    @Test
    public void ResetAppState() {
        sideMenuPage = homePage.clickSideMenuPage();
        sideMenuPage.resetAppState();
    }

}
