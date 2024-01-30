package com.nttdata.steps;

import com.nttdata.page.MainPage;
import org.openqa.selenium.WebDriver;

public class MainSteps {
    private WebDriver driver;

    //constructor
    public MainSteps(WebDriver driver){
        this.driver = driver;
    }

    public void goPageLogin(){
        this.driver.findElement(MainPage.btnMyAccount).click();
        this.driver.findElement(MainPage.btnInitSession).click();
    }

}
