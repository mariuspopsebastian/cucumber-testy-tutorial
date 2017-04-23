package org.fasttrackit.evomag;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.link.WebLink;
import org.fasttrackit.bazadedate.CrudoOperation;
import org.fasttrackit.bazadedate.Produs;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class Compara extends TestBase{
    private LoginViewEvomag page = new LoginViewEvomag();
    private SearchEvomag searchFlowEvomag = new SearchEvomag();

    @Test(dataProvider = "comparaProduse")
    public void comparaProduse(Produs produs){
        openLoginPage();
        page.login("qaautomat89@gmail.com","parolaevomag");
//        searchFlowEvomag.search("iphone 6s");
        WebLink inapoiInSite = new WebLink().setText("Inapoi in site");
        inapoiInSite.click();
        searchFlowEvomag.search(produs.getSearch());
        //Utils.sleep(5000);
//        searchFlowEvomag.clickIphone();

//        WebLink firstResult = new WebLink().setText("Telefon Mobil Apple iPhone 6S, Procesor Apple A9, IPS LED-backlit Multi?Touch 4.7 , 2GB RAM, 16GB flash, 12MP, Wi-Fi, 4G, iOS 9 (Rose Gold)");
        WebLink firstResult = new WebLink().setText(produs.getProdus());
        firstResult.click();

        WebLocator pretElement = new WebLocator().setClasses("pret_rons");
        String pret = pretElement.getText();
        System.out.println(pret);
        pret = pret.replace(",00 Lei", "").replace(".", "");
        Integer pretInt = new Integer(pret);
        System.out.println(pretInt);

        assertThat(pretInt, lessThan(produs.getPret()));

    }

    @DataProvider
    public Object[][] comparaProduse() {
        try {
            List<Produs> produse = CrudoOperation.readProdus();

            Object [][] objArray = new Object[produse.size()][];

            for(int i=0;i< produse.size();i++){
                objArray[i] = new Object[1];
                objArray[i][0] = produse.get(i);
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
