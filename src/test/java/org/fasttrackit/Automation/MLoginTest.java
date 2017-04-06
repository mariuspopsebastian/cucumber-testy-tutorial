package org.fasttrackit.Automation;


import com.sdl.selenium.web.table.Table;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MLoginTest extends TestBase {

   // private Loginpage loginpage;
    private LoginView page = new LoginView();

   // public MLoginTest() {
   //     loginpage = PageFactory.initElements(driver, Loginpage.class);
   // }

    @Test
    public void validLogind() {
        openLoginPage();
        

        page.login("eu@fast.com", "eu.pass");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

    }


    @Test(dependsOnMethods = "validLogind")
    public void invalidPasswordTest() {
        openLoginPage();

        page.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is("Invalid user or password!"));


    }


}
