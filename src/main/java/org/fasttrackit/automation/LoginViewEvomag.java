package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;


public class LoginViewEvomag {

    private WebLocator emailField = new WebLocator().setId("LoginClientForm_Email");
    private WebLocator passField = new WebLocator().setName("LoginClientForm[Password]");
    private WebLocator loginBtn = new WebLocator().setName("yt1");


    public void login(String email, String pass) {

        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

    }
}
