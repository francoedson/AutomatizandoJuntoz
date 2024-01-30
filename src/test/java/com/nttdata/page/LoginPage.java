package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By txtEmail = By.xpath("//input[@id='UserName']");
    public static By txtPass = By.xpath("//input[@id='Password']");
    public static By btnLogin = By.xpath("//input[@class='btn btn-primary form-control']");
}
