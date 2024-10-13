package com.univercity.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class ReferAFriendPage {

    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;

    public ReferAFriendPage(){
        PageFactory.initElements(driver,this);
    }

    public void fillReferAFriend() throws InterruptedException {
        continueBtn.click();
    }
}
