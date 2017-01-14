package org.fasttrackit.Automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MLoginTest extends TestBase {
    @Test
    public void validLogind(){
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement findEmail = driver.findElement(By.name("username"));
        WebElement findPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        findEmail.sendKeys("tu@fast.com");
        findPassword.sendKeys("tu.pass");
        loginButton.click();


        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();









    }
}
