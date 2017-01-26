package org.fasttrackit.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {
    @FindBy (name = "password")
    private WebElement currentPasswordField;
    @FindBy (name = "newPasswordRepeat")
    private WebElement repeatPasswordField;
    @FindBy (name = "newPassword")
    private WebElement newPasswordField;
    //TO DO save button;

    public void changePasswordPage(String currentPass, String repeatPass, String newPassword) {
        currentPasswordField.sendKeys("currentPass");
        repeatPasswordField.sendKeys("newPass");
        newPasswordField.sendKeys("newPass");
    }

    //TO DO click on Save button




}
