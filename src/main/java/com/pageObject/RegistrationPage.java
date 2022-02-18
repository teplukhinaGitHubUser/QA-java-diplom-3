package com.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    @FindBy(how = How.XPATH, using = ".//input")
    private ElementsCollection registrationFields;
    @FindBy(how = How.XPATH, using = ".//button")
    private SelenideElement registrationButton;
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement validationMessage;

    public void setName(String name) {
        registrationFields.get(0).setValue(name);
    }

    public void setEmail(String email) {
        registrationFields.get(1).setValue(email);
    }

    public void setPassword(String password) {
        registrationFields.get(2).setValue(password);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
    public void clickToLoginButton() {
        loginButton.click();
    }

    public String getValidationMessage(){
        return validationMessage.getText();
    }
}
