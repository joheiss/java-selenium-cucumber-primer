package stepDefinitions.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jovisco.utils.GlobalVars.HOME_PAGE_URL;

public class LoginPage extends BasePage{

    public static final String LOGIN_PAGE_URL = HOME_PAGE_URL + "/Login-Portal/index.html";

    private @FindBy(id = "text")
    WebElement userNameField;
    private @FindBy(id = "password")
    WebElement passwordField;
    private @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage() {
        super();
    }
    public void navigateToLoginPage() {
        navigateToUrl(LOGIN_PAGE_URL);
    }
    public void enterUserName(String userName) {
        enterValue(userNameField, userName);
    }
    public void enterPassword(String password) {
        enterValue(passwordField, password);
    }
    public void clickLoginButton() {
        clickButton(loginButton);
    }
    public void verifySucessfulLogin() {
        verifyAlertMessage("validation succeeded");
    }
    public void verifyUnsucessfulLogin() {
        verifyAlertMessage("validation failed");
    }

}
