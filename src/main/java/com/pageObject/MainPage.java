package com.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement goToAccountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsTab;
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesTab;
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement mainTab;
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement selectedTab;


    public void clickToAccountButton(){
        accountButton.click();
    }
    public void clickToGoToAccountButton(){
        goToAccountButton.click();
    }

    public boolean orderButtonIsVisible(){
        return orderButton.should(Condition.visible).isDisplayed();
    }

    public void clickToBuns() {
        bunsTab.should(Condition.visible).click();
    }
    public void clickToSauces() {
        saucesTab.click();
    }
    public void clickToMain() {
        mainTab.click();
    }

    public String getSelectedTab(){
        return selectedTab.getText();
    }
}
