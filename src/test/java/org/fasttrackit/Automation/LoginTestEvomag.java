package org.fasttrackit.Automation;

import org.fasttrackit.automation.LoginViewEvomag;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

/**
 * Created by Marius on 23-Mar-17.
 */
public class LoginTestEvomag extends TestBase{

    private LoginViewEvomag page = new LoginViewEvomag();


    @Test
    public void validLogin(){
        openLoginPage();

        page.login("qaautomat89@gmail.com","parolaevomag");


    }
}
