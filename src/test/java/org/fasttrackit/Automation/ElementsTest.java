package org.fasttrackit.Automation;

import com.sdl.selenium.bootstrap.button.Upload;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.DropDown;
import org.fasttrackit.automation.ElementsView;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import java.util.Locale;

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

    @Test
    public void dropDownTest (){
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        page.autoOption.click();
        page.manualOption.click();
    }

    @Test
    public void dropDownComponentTest(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        DropDown dropDown = new DropDown();
        dropDown.select("Manual");

        Utils.sleep(500);
        dropDown.select("Auto");

        MultiSelect source = new MultiSelect().setClasses("multiselect");
        source.select("Tomatoes", "Mozzarella");

        DatePicker datePicker = new DatePicker();
        datePicker.setDate("9", "Apr", "2017");
        Utils.sleep(1000);

        datePicker.select("11/03/2016", "dd/MM/yyyy", Locale.ENGLISH);
        //datePicker.select("11/03/2016");

    }
    private Form form = new Form("Form Title");
    private Upload uploadfile = new UploadFile(form);

    @Test
    public void uploadTest(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        uploadfile.upload(PropertiesReader.RESOURCES_DIRECTORY_PATH+ "\\feature\\login\\login.feature");



    }






}
