package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends DriverManager {
//DriverManager driverManager = new DriverManager();

@FindBy(css = "a[class='ico-register']")
WebElement registerButtonOnHomePage;


@FindBy(id = "FirstName")
    WebElement firstNameInputField;

@FindBy(id = "LastName")
    WebElement lastNameInputField;

@FindBy(id = "Email")
    WebElement emailInputBox;

@FindBy(id = "Password")
    WebElement passwordInputBox;

@FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInputField;

@FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButtonOnRegisterPage;

@FindBy(xpath = "//div[@class='result']")
    WebElement registrationCompletedText;

@FindBy(css = "a[class='ico-logout']")
        WebElement logOutButton;



public void clickonRegisterButtonOnHomePage(){
    registerButtonOnHomePage.click();
}
public void enterFirstName(String firstName){
    firstNameInputField.sendKeys(firstName);
}

public void enterLastName(String lastName){
    lastNameInputField.sendKeys(lastName);
}
public void inputEmail(String email){
    emailInputBox.clear();
    int myRandomNumber = generateRandomNumber();
    emailInputBox.sendKeys(myRandomNumber+email);
}

public void inputPassword(String password){
    passwordInputBox.sendKeys(password);
}

public void inputConfirmPassword(String confirmPassword){
    confirmPasswordInputField.sendKeys(confirmPassword);
}

// below method is used for DataTable
public void enterRegistrationDetails(String firstName, String lastName, String email, String password, String confirmPassword){
    firstNameInputField.clear();
    firstNameInputField.sendKeys(firstName);
    lastNameInputField.clear();
    lastNameInputField.sendKeys(lastName);

    emailInputBox.clear();
    int myRandomNumber = generateRandomNumber();
    emailInputBox.sendKeys(myRandomNumber+email);

    passwordInputBox.clear();
    passwordInputBox.sendKeys(password);
    confirmPasswordInputField.clear();
    confirmPasswordInputField.sendKeys(confirmPassword);
}

public void clickOnRegisterButtonOnRegisterPage(){
    registerButtonOnRegisterPage.click();
}

public String  getRegistrationCompletedText(){
   return registrationCompletedText.getText();
}

public boolean checkLogoutButtonIsDisplayed(){
    return logOutButton.isDisplayed();
}



}
