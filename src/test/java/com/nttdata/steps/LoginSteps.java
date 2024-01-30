package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }


    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.txtEmail);
        userInputElement.sendKeys(user);

    }


    public void typePassword(String password){
        this.driver.findElement(LoginPage.txtPass).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(LoginPage.btnLogin).click();
    }


}
