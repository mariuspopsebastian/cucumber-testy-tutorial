package org.fasttrackit.Automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class MLoginTest2 extends TestBase {
    @Test
    public void MLogin2(){

       driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");


        WebElement findLoginButton = driver.findElement(By.className("login-btn"));
        WebElement findEmail = driver.findElement(By.id("email"));
        findLoginButton.click();
        WebElement errormessage = driver.findElement(By.className("error-msg error"));










    }

}
