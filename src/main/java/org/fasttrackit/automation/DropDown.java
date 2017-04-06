package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;

public class DropDown extends WebLocator{

    public DropDown(){
        this.setClasses("dropdown-toggle");
        }


   // private WebLocator autoOption = new WebLocator().setText("Auto").setClasses("filter-option");
    private WebLocator menuDropDown = new WebLocator().setClasses("dropdown-menu");
    private WebLocator option = new WebLocator(menuDropDown).setText("NO ADB");

    public void select(String value) {
        this.click();
        option.setText(value);
        option.click();


    }
}
