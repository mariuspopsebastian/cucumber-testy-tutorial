package org.fasttrackit.Automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TableTest extends TestBase {



    @Test
    public void selectTableRowTest(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

       // WebElement checkbox = driver.findElement(By.xpath("//table//input"));
        WebLocator checkbox = new WebLocator().setElPath("//table//input");
        checkbox.click();

    }

    @Test
    public void selectRowByEmail(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        Table table = new Table();

        Row row = table.getRow(new Cell(4, "davidmiller@mail.com"));

        CheckBox checkBox = new CheckBox(row);
        checkBox.click();






    }
}
