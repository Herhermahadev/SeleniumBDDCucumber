package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {
     // convert locater in to variable
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement textOnHomePage;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginButtonOnHomePage;

    //create method of action
public String getTextFromHomePage(){
  return  textOnHomePage.getText();
}

public void clickOnLoginButtononHomePage(){
    loginButtonOnHomePage.click();
}

}