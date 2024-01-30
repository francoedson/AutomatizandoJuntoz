package com.nttdata.steps;

import com.nttdata.page.MenuPage;
import org.openqa.selenium.WebDriver;

public class MenuSteps {
    private WebDriver driver;


    public MenuSteps(WebDriver driver){
        this.driver = driver;
    }


    public String getMyName(){
        return this.driver.findElement(MenuPage.myName).getText();
    }

    public void goDeliveryFree(){
        this.driver.findElement(MenuPage.sectionDeliveryFree).click();
    }
}
