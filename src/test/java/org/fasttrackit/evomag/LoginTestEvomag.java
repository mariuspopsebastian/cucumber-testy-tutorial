package org.fasttrackit.evomag;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.bazadedate.Produs;
import org.fasttrackit.evomag.LoginViewEvomag;
import org.fasttrackit.bazadedate.Cont;
import org.fasttrackit.bazadedate.CrudoOperation;
import org.fasttrackit.evomag.SearchEvomag;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class LoginTestEvomag extends TestBase{

    private LoginViewEvomag page = new LoginViewEvomag();



    @Test
    public void validLogin(){
        openLoginPage();

        page.login("qaautomat89@gmail.com","parolaevomag");
        System.out.println("Te ai logat cu succes");
        WebLink inapoiInSite = new WebLink().setText("Inapoi in site");
        inapoiInSite.click();
        page.logout();
    }

    @Test(dataProvider = "invalidUsers")
    public void invalidLogin(Cont cont){
        openLoginPage();

        page.login(cont.getEmail(), cont.getPassword());

        WebLocator errorMsg = new WebLocator().setClasses("err1");
        System.out.println(errorMsg.getText());

        String expectedMsg = "Username si/sau parola incorecta !";
        assertThat(errorMsg.getText(), is(expectedMsg));
    }

    @DataProvider
    public Object[][] invalidUsers() {
        try {
            List<Cont> credentiale = CrudoOperation.readCredentiale();

            Object [][] objArray = new Object[credentiale.size()][];

            for(int i=0;i< credentiale.size();i++){
                objArray[i] = new Object[1];
                objArray[i][0] = credentiale.get(i);
            }

            return objArray;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
