package com.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    @FindBy(how = How.LINK_TEXT, using = "Профиль")
    private SelenideElement profileButton;
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement constructorButton;
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logoButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    public boolean profileButtonIsDisplayed(){
       return profileButton.should(Condition.visible).isDisplayed();
    }

    public void clickToConstructorButton(){
        constructorButton.click();
    }
    public void clickToLogoButton(){
        logoButton.click();
    }
    public void clickToLogoutButton(){
        logoutButton.click();
    }
}
