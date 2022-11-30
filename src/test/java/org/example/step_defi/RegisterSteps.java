package org.example.step_defi;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.RegisterPage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegisterSteps extends DriverManager {

    RegisterPage registerPage=new RegisterPage();
    //DriverManager driverManager = new DriverManager();
    @Then("^I click on register button$")
    public void i_click_on_register_button() throws Throwable {
        registerPage.clickonRegisterButtonOnHomePage();
    }
    @Then("^I enter firstname \"([^\"]*)\"$")
    public void i_enter_firstname(String firstName) throws Throwable {
        registerPage.enterFirstName(firstName);
    }
    @Then("^I enter lastname \"([^\"]*)\"$")
    public void i_enter_lastname(String lastName) throws Throwable {
        registerPage.enterLastName(lastName);
    }
    @Then("^I enter valid email \"([^\"]*)\" on registration page$")
    public void i_enter_valid_email_on_registration_page(String email) throws Throwable {
        registerPage.inputEmail(email);
    }
    @Then("^I enter valid password \"([^\"]*)\" on registration page$")
    public void i_enter_valid_password_on_registration_page(String password) throws Throwable {
        registerPage.inputPassword(password);
    }
    @Then("^I enter valid confirm password \"([^\"]*)\" on registration page$")
    public void i_enter_valid_confirm_password_on_registration_page(String confirmPassword) throws Throwable {
        registerPage.inputConfirmPassword(confirmPassword);
    }
    @When("^I click on register button on register page$")
    public void i_click_on_register_button_on_register_page() throws Throwable {
        registerPage.clickOnRegisterButtonOnRegisterPage();

    }

    @Then("^I should see \"([^\"]*)\" text on register page$")
    public void i_should_see_text_on_register_page(String expectedRegisterCompletedText) throws Throwable {
        String actualRegisterCompletedText = registerPage.getRegistrationCompletedText();
        System.out.println(actualRegisterCompletedText);
        System.out.println(expectedRegisterCompletedText);
        assertThat(actualRegisterCompletedText, Matchers.is(equalToIgnoringCase(expectedRegisterCompletedText)));
    }

    @Then("^I should see log out button displayed on register page$")
    public void i_should_see_log_out_button_displayed_on_register_page() throws Throwable {
        boolean logoutButtonIsDisplayed = registerPage.checkLogoutButtonIsDisplayed();
            assertThat(logoutButtonIsDisplayed, Matchers.is(true));

    }

    @Then("^I should see \"([^\"]*)\" text in url on register page$")
    public void i_should_see_text_in_url_on_register_page(String expectedUrlText) throws Throwable {
            String actualUrl = getUrl();
            System.out.println(actualUrl);
            assertThat(actualUrl, containsString(expectedUrlText));
    }

    @When("^I enter following data for registration$")
    public void i_enter_following_data_for_registration(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
       List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        System.out.println(data);
        System.out.println((dataTable));
        registerPage.enterRegistrationDetails(
                data.get(0).get("firstname"),
                data.get(0).get("lastname"),
                data.get(0).get("email"),
                data.get(0).get("password"),
                data.get(0).get("confirm password"));

    }


}

