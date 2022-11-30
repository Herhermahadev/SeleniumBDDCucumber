package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends DriverManager {

    @FindBy(css = "div[class='page-title'] h1")
    WebElement contactUsTextOnContactUsPage;

    public String getContactUsText(){
        return contactUsTextOnContactUsPage.getText();

    }

}
