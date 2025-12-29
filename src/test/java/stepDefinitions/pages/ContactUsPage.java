package stepDefinitions.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.jovisco.utils.GlobalVars.HOME_PAGE_URL;

public class ContactUsPage extends BasePage {

    public static final String CONTACT_US_PAGE_URL = HOME_PAGE_URL + "/Contact-Us/contactus.html";

    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameField;
    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameField;
    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;
    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentField;
    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;
    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement welcomeMessage;

    public ContactUsPage() {
        super();
    }
    public void navigateToContactUsPage() {
        navigateToUrl(CONTACT_US_PAGE_URL);
    }
    public void enterFirstName(String firstName) {
        enterValue(firstNameField, firstName);
    }
    public void enterLastName(String lastName) {
        enterValue(lastNameField, lastName);
    }
    public void enterEmail(String email) {
        enterValue(emailField, email);
    }
    public void enterComment(String comment) {
        enterValue(commentField, comment);
    }
    public void clickSubmitButton() {
        clickButton(submitButton);
    }
    public void verifyContactUsPageWelcomeMessage() {
        waitForElement(welcomeMessage);
        var found = welcomeMessage.getText().contains("Thank You");
        Assert.assertTrue(found);
    }
}
