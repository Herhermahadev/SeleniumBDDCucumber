package org.example.step_defi;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps extends DriverManager {

    LoginPage loginPage = new LoginPage();

    @Then("^I should see \"([^\"]*)\" text on login page$")
    public void iShouldSeeTextOnLoginPage(String expectedWelcomeTextOnLoginPage) throws Throwable {

        String actualWelcomeText = loginPage.getWelcomeTextFromLoginPage();
        System.out.println(actualWelcomeText);
        System.out.println(expectedWelcomeTextOnLoginPage);
        assertThat(actualWelcomeText, is(equalToIgnoringCase(expectedWelcomeTextOnLoginPage)));

    }

    @And("^I should see text \"([^\"]*)\" in url on login page$")
    public void iShouldSeeTextInUrlOnLoginPage(String expectedUrlText) throws Throwable {
        String actualUrl = getUrl();
        System.out.println(actualUrl);
        assertThat(actualUrl, containsString(expectedUrlText));
    }

    @When("^I enter valid email \"([^\"]*)\"$")
    public void i_enter_valid_email(String email) throws Throwable {
     loginPage.enterEmail(email);
    }

    @When("^enter valid password \"([^\"]*)\"$")
    public void enter_valid_password(String password) throws Throwable {
        loginPage.enterPassword(password);
    }
    @When("^I click on login button on login page$")
    public void i_click_on_login_button_on_login_page() throws Throwable {
        loginPage.clickOnLoginButtonOnLoginPage();
    }

    @Then("^I should see log out button displayed$")
    public void i_should_see_log_out_button_displayed() throws Throwable {
       boolean LogoutButtonIsDisplayed =  loginPage.checkLogoutButtonIsDisplayed();
       assertThat(LogoutButtonIsDisplayed, is(true));
    }
}



