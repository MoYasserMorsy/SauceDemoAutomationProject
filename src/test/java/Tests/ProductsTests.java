package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTests extends BaseTests {
    private ProductsPage productsPage;

    @DataProvider(name = "productsOrder")
    public Object[][] getOrderData() {
        return new Object[][]{
                {"az", "Name (A to Z)"},
                {"za", "Name (Z to A)"},
                {"lohi", "Price (low to high)"},
                {"hilo", "Price (high to low)"}
        };
    }

    @Test(dataProvider = "productsOrder")
    public void testSuccessfulOder(String priceOrder, String name) {
        productsPage = homePage.clickProductPage();
        productsPage.selectFromDropDown(priceOrder);//az-za-lohi-hilo
        System.out.println(name);
        if(name.equals("Name (A to Z)")){
            Assert.assertEquals(productsPage.getTextFirstOrder(),"Sauce Labs Backpack","the order is from A to Z");
        }
        else if(name.equals("Name (Z to A)")){
            Assert.assertEquals(productsPage.getTextFirstOrder(),"Test.allTheThings() T-Shirt (Red)","the order is from Z to A");
        }
        else if(name.equals("Price (low to high)")){
            Assert.assertEquals(productsPage.getTextFirstOrder(),"Sauce Labs Onesie","the order is from low to high");
        }
        else if(name.equals("Price (high to low)")){
            Assert.assertEquals(productsPage.getTextFirstOrder(),"Sauce Labs Fleece Jacket","the order is from high to low");
        }
        else{
            System.out.println("No match element");
        }


    }

}
