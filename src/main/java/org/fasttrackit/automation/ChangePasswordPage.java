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
    @FindBy (xpath = "//*[@id='preferences-win']//button[normalize-space(text())='Save']")
    private WebElement saveBtn;

    public void changePasswordPage(String currentPass, String repeatPass, String newPassword) {
        currentPasswordField.sendKeys("currentPass");
        repeatPasswordField.sendKeys("newPass");
        newPasswordField.sendKeys("newPass");
        saveBtn.click();
    }

    //TO DO click on Save button




}
