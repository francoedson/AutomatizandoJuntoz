package com.nttdata.steps;

import com.nttdata.page.DeliveryFreePage;
import com.nttdata.page.MenuPage;
import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartSteps {
    private WebDriver driver;

    //contrsuctor
    public ShoppingCartSteps(WebDriver driver){
        this.driver = driver;
    }

    public int getProductsSize(){
        List<WebElement> items = this.driver.findElements(ShoppingCartPage.cardProducts);
        return items.size();
    }

    public String getPrice(){
        return this.driver.findElement(ShoppingCartPage.txtPrice).getText();
    }
}
