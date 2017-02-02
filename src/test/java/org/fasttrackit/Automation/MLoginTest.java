package org.fasttrackit.Automation;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.Loginpage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MLoginTest extends TestBase {

    private Loginpage loginpage;

    public MLoginTest() {
        loginpage = PageFactory.initElements(driver, Loginpage.class);
    }

    @Test
    public void validLogind() {
        openWebpage();

        loginpage.login("eu@fast.com", "eu.pass");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

    }


    @Test(dependsOnMethods = "validLogind")
    public void invalidPasswordTest() {
        openWebpage();

        loginpage.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is("Invalid user or password!"));


    }


}
