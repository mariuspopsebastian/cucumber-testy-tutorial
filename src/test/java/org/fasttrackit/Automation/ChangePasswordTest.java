package org.fasttrackit.Automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.ChangePasswordPage;
import org.fasttrackit.automation.Loginpage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class ChangePasswordTest extends TestBase {

    private Loginpage loginpage;
    private ChangePasswordPage page;

    public ChangePasswordTest() {
        loginpage = PageFactory.initElements(driver, Loginpage.class);
        page = PageFactory.initElements(driver, ChangePasswordPage.class);
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword (){
        openWebpage();
        loginpage.login("eu@fast.com", "eu.pass");
        WebElement preferencesbtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesbtn.click();

        Utils.sleep(2000);


        page.changePasswordPage("wrong.pass", "new.pass","new.pass" );



    }




}
