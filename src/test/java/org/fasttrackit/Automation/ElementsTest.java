package org.fasttrackit.Automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ElementsTest extends TestBase {
    private LoginView loginView = new LoginView();

    private CheckBox stopProcessCheckBox = new CheckBox().setElPath("/html/body/form[1]/div[3]/label/input");
    private CheckBox labelWithEnter = new CheckBox().setElPath("/html/body/form[1]/div[4]/label/input");
    private WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    private WebLocator widthEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);

    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        stopProcessCheckBox.click();
        labelWithEnter.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        widthEnterLabel.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        widthEnterLabel.click();

        assertThat("Stop the process is not selected!",stopProcessCheckBox.isSelected(), is(true));
        assertThat("Label with Enter.",labelWithEnter.isSelected(), is(true));



    }







}
