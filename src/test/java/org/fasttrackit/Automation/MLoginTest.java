package org.fasttrackit.Automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MLoginTest extends TestBase {
    @Test
    public void validLogind(){
        openWebpage();

        login("eu@fast.com", "eu.pass");

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

    }





    @Test(dependsOnMethods = "validLogind")
    public void invalidPasswordTest(){
        openWebpage();

        login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is ("Invalid user or password!"));





    }

    @Test
    public void changePasswordWithInvalidCurrentPassword (){
        openWebpage();
        login("eu@fast.com", "eu.pass");
        WebElement preferencesbtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesbtn.click();



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

    public void login(String user, String password){
        WebElement findEmail = driver.findElement(By.name("username"));
        WebElement findPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        findEmail.sendKeys(user);
        findPassword.sendKeys(password);
        loginButton.click();
    }
}
