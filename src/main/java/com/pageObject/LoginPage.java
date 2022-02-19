package com.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registrationButton;
    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    private SelenideElement resetPasswordButton;
    @FindBy(how = How.XPATH, using = ".//input")
    private ElementsCollection loginFields;
    @FindBy(how = How.XPATH, using = ".//button")
    private SelenideElement loginButton;

    public void clickToRegistrationButton(){
        registrationButton.click();
    }
    public void clickToResetPasswordButton(){
        registrationButton.click();
    }

    public void setEmail(String email) {
        loginFields.get(0).setValue(email);
    }

    public void setPassword(String password) {
        loginFields.get(1).setValue(password);
    }

    public void clickToLoginButton() {
        loginButton.click();
    }


    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }
}
