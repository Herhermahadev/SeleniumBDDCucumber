package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {

    DriverManager driverManager=new DriverManager();
     // convert locater in to variable
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement textOnHomePage;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginButtonOnHomePage;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    WebElement contactUsBtn;

    //create method of action
public String getTextFromHomePage(){
  return  textOnHomePage.getText();
}

public void clickOnLoginButtononHomePage(){
    loginButtonOnHomePage.click();
}

public void clickOnContactUsBtnonHomePage(){

    scrollTo(contactUsBtn); //from extend by inheritance
    //driverManager.scrollTo(contactUsBtn); //from object creation
    contactUsBtn.click();
}

}