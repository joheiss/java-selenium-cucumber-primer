package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import stepDefinitions.base.Person;
import stepDefinitions.pages.ContactUsPage;

import java.util.Locale;

public class ContactUsSteps {

    private final ContactUsPage contactUsPage;

    private final Faker faker = new Faker(Locale.GERMANY);
    private Person person;

    public ContactUsSteps(ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }

    @Before(order = 1)
    public void setup() {
        person = fakePerson();
    }

    @Given("user navigates to ContactUs page")
    public void user_navigates_to_contact_us_page() {
        contactUsPage.navigateToContactUsPage();
    }
    @When("user enters first name")
    public void user_enters_first_name() {
        contactUsPage.enterFirstName(person.firstName());
    }
    @And("user enters last name")
    public void user_enters_last_name() {
        contactUsPage.enterLastName(person.lastName());
    }
    @And("user enters unique email address")
    public void user_enters_unique_email_address() {
        contactUsPage.enterEmail(person.email());
    }
    @And("user enters a comment")
    public void user_enters_a_comment() {
        var comment = faker.lorem().paragraph() + System.lineSeparator() + person.fullName();
        contactUsPage.enterComment(comment);
    }
    @And("user enters the first name {string}")
    public void user_enters_the_first_name(String firstName) {
        contactUsPage.enterFirstName(firstName);
    }
    @And("user enters the last name {string}")
    public void user_enters_the_last_name(String lastName) {
        contactUsPage.enterLastName(lastName);
    }
    @And("users enters the email address {string}")
    public void users_enters_the_email_address(String email) {
        contactUsPage.enterEmail(email);
    }
    @And("user enters the comment {string}")
    public void user_enters_the_comment(String comment) {
        contactUsPage.enterComment(comment);
    }
    @And("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        contactUsPage.clickSubmitButton();
    }
    @Then("system displays a thank you message")
    public void system_displays_a_thank_you_message() {
        contactUsPage.verifyContactUsPageWelcomeMessage();
    }

    private Person fakePerson() {
        var firstName = faker.name().firstName();
        var lastName = faker.name().lastName();
        var email = faker.internet().emailAddress(firstName + "." + lastName);
        return new Person(firstName, lastName, email);
    }
}
