package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTests extends BaseTests {

    @DataProvider(name ="confirmPurchaser")
    public Object[][]  getDataToCartPurchaser(){
        return new Object[][]{
            {"Mohamed","Yasser","2015"}

        };
    }
    @Test(priority = 1)
    public void removeItemFromCart (){
        CartPage cartPage=homePage.clickProductPage().clickCartPage();
        Assert.assertEquals(cartPage.getTextAddedItem(),"Sauce Labs Backpack","The item is correct");
        cartPage.removeItem();
    }
    @Test(priority = 2,dataProvider = "confirmPurchaser")
    public void testCart(String firstname, String lastname, String zipCode){
        CartPage cartPage=homePage.clickProductPage().clickCartPage();
        cartPage.fillCheckout(firstname,lastname,zipCode);
        Assert.assertEquals(cartPage.getTextFinishOrderPage(),"Thank you for your order!","finish it");
        Assert.assertEquals(cartPage.BackToHomePage(),"Products","Done ");





    }
}
