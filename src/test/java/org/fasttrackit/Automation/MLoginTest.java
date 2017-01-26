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
    public void validLogind(){
        openWebpage();

        loginpage.login("eu@fast.com", "eu.pass");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

    }





    @Test(dependsOnMethods = "validLogind")
    public void invalidPasswordTest(){
        openWebpage();

        loginpage.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is ("Invalid user or password!"));





    }

    @Test
    public void changePasswordWithInvalidCurrentPassword (){
        openWebpage();
        loginpage.login("eu@fast.com", "eu.pass");
        WebElement preferencesbtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesbtn.click();

        Utils.sleep(2000);


        WebElement currentPasswordField = driver.findElement(By.name("password"));
        WebElement repeatPasswordField = driver.findElement(By.name("newPasswordRepeat"));
        WebElement newPasswordField = driver.findElement(By.name("newPassword"));

        currentPasswordField.sendKeys("wrong.pass");
        newPasswordField.sendKeys("new.pass");
        repeatPasswordField.sendKeys("new.pass");


    }

    private void openWebpage() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}
