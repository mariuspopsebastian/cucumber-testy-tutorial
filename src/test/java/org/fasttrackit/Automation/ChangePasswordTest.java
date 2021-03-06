package org.fasttrackit.Automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.ChangePasswordPage;
import org.fasttrackit.automation.Loginpage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ChangePasswordTest extends TestBase {

    private Loginpage loginpage;
    private ChangePasswordPage page;

    public ChangePasswordTest() {
        loginpage = PageFactory.initElements(driver, Loginpage.class);
        page = PageFactory.initElements(driver, ChangePasswordPage.class);
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword (){
        openPage();

        page.changePasswordPage("wrong.pass", "new.pass","new.pass" );

        assertThat(page.getStatusMessage(), is("Your preview password is incorrect!"));




    }
    @Test
    public void changePasswordWithInvalidRepeatPassword (){
        openPage();

        page.changePasswordPage("eu.pass", "new1.pass","new2.pass");

        assertThat(page.getStatusMessage(), is("Password does not match the confirm password!"));

    }
    public void openPage() {
        openLoginPage();
        loginpage.login("eu@fast.com", "eu.pass");
        WebElement preferencesbtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesbtn.click();
        Utils.sleep(2000);
    }




}
