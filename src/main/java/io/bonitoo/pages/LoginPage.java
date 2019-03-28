package io.bonitoo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(css = "input#username")
    WebElementFacade usernameInput;

    @FindBy(css = "input#password")
    WebElementFacade passwordInput;

    @FindBy(css = "button")
    WebElementFacade button;

    public WebElementFacade getUsernameInput() {
        return usernameInput;
    }

    public WebElementFacade getPasswordInput() {
        return passwordInput;
    }

    public WebElementFacade getButton() {
        return button;
    }
}
