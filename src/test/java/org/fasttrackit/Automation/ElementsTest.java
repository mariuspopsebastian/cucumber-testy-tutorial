package org.fasttrackit.Automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.ElementsView;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ElementsTest extends TestBase {
    private LoginView loginView = new LoginView();
    private ElementsView page = new ElementsView();


    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        page.stopProcessCheckBox.click();
        page.labelWithEnter.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.widthEnterLabel.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.widthEnterLabel.click();

        assertThat("Stop the process is not selected!",page.stopProcessCheckBox.isSelected(), is(true));
        assertThat("Label with Enter.",page.labelWithEnter.isSelected(), is(true));



    }







}
