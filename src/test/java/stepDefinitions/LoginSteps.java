package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
        loginPage.navigateToLoginPage();
    }
    @When("user enters the username {word}")
    public void user_enters_the_username(String userName) {
        loginPage.enterUserName(userName);
    }
    @And("user enters the password {}")
    public void user_enters_the_password(String password) {
        loginPage.enterPassword(password);
    }
    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("system displays an alert with message {}")
    public void system_displays_an_alert_with_message(String message) {
        loginPage.verifyAlertMessage(message);
    }
}
