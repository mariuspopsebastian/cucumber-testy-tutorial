package org.fasttrackit.evomag;

import com.sdl.selenium.web.WebLocator;
import org.fasttrackit.bazadedate.Cont;
import org.fasttrackit.bazadedate.CrudoOperation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginViewEvomag {

    private WebLocator emailField = new WebLocator().setId("LoginClientForm_Email");
    private WebLocator passField = new WebLocator().setName("LoginClientForm[Password]");
    private WebLocator loginBtn = new WebLocator().setName("yt1");
    private WebLocator contBtn = new WebLocator().setText("CONTUL MEU");
    private WebLocator logoutBtn = new WebLocator().setClasses("CosAchizitii");



    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();
    }

    public void logout(){
        contBtn.click();
        logoutBtn.click();
    }


}
