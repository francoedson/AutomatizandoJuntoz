package com.nttdata.steps;

import com.nttdata.page.DeliveryFreePage;
import com.nttdata.page.MainPage;
import com.nttdata.page.MenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import java.util.List;

public class DeliveryFreeSteps {
    private WebDriver driver;

    //contrsuctor
    public DeliveryFreeSteps(WebDriver driver){
        this.driver = driver;
    }

    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(DeliveryFreePage.cardItems);
        return items.size();
    }


    public void addShoppingCart() {
        this.driver.findElement(DeliveryFreePage.btnCardItem).click();
    }

    public void goShoppingCart() {
        this.driver.findElement(DeliveryFreePage.btnShoppingCart).click();
    }
}
