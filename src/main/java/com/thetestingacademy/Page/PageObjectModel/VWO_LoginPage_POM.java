package com.thetestingacademy.Page.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VWO_LoginPage_POM {

    WebDriver driver;


    //constructor
    public VWO_LoginPage_POM(WebDriver driver)
    {
        this.driver = driver;
    }

    //page locators
    private By email_address = By.id("login-username");
    private By password = By.id("login-password");
    private By forget_password = By.xpath("//button[@data-qa='juvuwepeyi']");
    private By signin_button = By.xpath("//span[@data-qa='ezazsuguuy']");
    private By rememberme_checkbox = By.xpath("//label[@data-qa='fufufesepe']/span[2]");
    private By signinUsing_SSO = By.xpath("//button[@data-qa='dobevozose']");
    private By start_a_free_trial_link = By.xpath("//a[@data-qa='bericafeqo']");
    private By error_message = By.id("js-notification-box-msg");
    private By vmo_image =By.xpath("//img[@data-qa='cemaxumuwu']");

    //page actions
    public String login_to_vwo_using_invalid_credentials(String username,String password1)
    {
        driver.findElement(email_address).sendKeys(username);
        driver.findElement(password).sendKeys(password1);
        driver.findElement(signin_button).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_message));
        String error_text = driver.findElement(error_message).getText();

        return error_text;
    }



}
