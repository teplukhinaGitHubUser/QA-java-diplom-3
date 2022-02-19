package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage {
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;

    public void clickToLoginButton() {
        loginButton.click();
    }
}
