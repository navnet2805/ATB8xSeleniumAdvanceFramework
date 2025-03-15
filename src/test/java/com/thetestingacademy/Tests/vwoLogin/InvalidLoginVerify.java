package com.thetestingacademy.Tests.vwoLogin;

import com.thetestingacademy.Page.PageObjectModel.VWO_LoginPage_POM;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.*;

public class InvalidLoginVerify {

    @Description("Verify the error message when signed in using invalid credentials")
    @Test
    public void Validate_error_message_with_invalid_credentials()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        VWO_LoginPage_POM vwo_loginPage_pom = new VWO_LoginPage_POM(driver);
        String error_message = vwo_loginPage_pom.login_to_vwo_using_invalid_credentials("admin","p123");

        assertThat(error_message).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Your email, password, IP address or location did not match");

        driver.quit();
    }
}
