package org.example.step_defi;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.example.driver.DriverManager;
import org.example.pages.ContactUsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactUsSteps extends DriverManager {
    ContactUsPage contactUsPage=new ContactUsPage();
    @Then("^I should see \"([^\"]*)\" text on contact us page$")
    public void i_should_see_text_on_contact_us_page(String expectedContactUsText) throws Throwable {
        String actualContactUsText = contactUsPage.getContactUsText();
        System.out.println(expectedContactUsText);
        assertThat(actualContactUsText, is(equalToIgnoringCase(expectedContactUsText)));
    }

    @And("^I should see \"([^\"]*)\" text in url on contact us page$")
    public void i_should_see_text_in_url_on_contact_us_page(String expectedUrlText) throws Throwable {
        String actualUrl = getUrl();
        System.out.println(actualUrl);
        assertThat(actualUrl, containsString(expectedUrlText));
    }




//    @Then("^I should see \"([^\"]*)\" text on contact us page$")
//    public void i_should_see_text_on_contact_us_page(String expectedContactUsTextOnContactUsPage) throws Throwable {
//        String actualContactUsText = contactUsPage.getTextFromContactUsPage();
//        System.out.println(expectedContactUsTextOnContactUsPage);
//        assertThat(actualContactUsText, is(equalToIgnoringCase(expectedContactUsTextOnContactUsPage)));
//    }
//
//    @Then("^I should see text \"([^\"]*)\" in url contact us page$")
//    public void i_should_see_text_in_url_contact_us_page(String expectedUrlText) throws Throwable {
//        String actualUrl = getUrl();
//        System.out.println(actualUrl);
//        assertThat(actualUrl, containsString(expectedUrlText));
//    }


}
