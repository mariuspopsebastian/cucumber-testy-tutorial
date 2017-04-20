package org.fasttrackit.evomag;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

/**
 * Created by Marius on 20-Apr-17.
 */
public class SearchEvomag {




    private TextField searchField = new TextField().setId("searchString").setClasses("sn-suggest-input");
    private WebLocator searchBtn = new WebLocator().setClasses("submit-search");
    private WebLocator iphoneItem = new WebLocator().setClasses("prod_list_detleft_poza", "prod_list_detleft","poza_tabel", "relative");
    private WebLocator wishlist =new WebLocator().setClasses("ordinary-a");
    private WebLocator wishlistform = new WebLocator().setClasses("Wishlist[Name]");
    private WebLocator wishlistSaveBtn = new WebLocator().setClasses("save-wishlist-edit", "create-new-wishlist");
    private WebLocator samsungItem = new WebLocator().setClasses("prod_list_detleft_poza", "prod_list_detleft_poza_tabel", "relative");

    public void search(String type){
        searchField.setValue(type);
        searchBtn.click();
    }

    public void clickIphone(){
        iphoneItem.click();
    }

    public void clickwishlist(){
        wishlist.click();
    }

    public void savewishlist(){
        wishlistform.click();
        wishlistform.sendKeys("Telefoane");
        wishlistSaveBtn.click();

    }

    public void searchSamsung(){
        searchField.click();
        searchField.sendKeys("samsung s7");
        searchBtn.click();

    }

    public void clickSamsung(){

    }

}
