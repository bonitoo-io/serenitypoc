package io.bonitoo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TestAppPage extends PageObject {

    @FindBy(css = "span#user")
    WebElementFacade userSpan;

    @FindBy(css = "input[name=message]")
    WebElementFacade nameInput;

    @FindBy(css = "a[href=\"javascript:submitForm()\"]")
    WebElementFacade submitForm;

    @FindBy(css = "a[href=\"/login\"]")
    WebElementFacade loginLink;

    @FindBy(css = "p#response")
    WebElementFacade responsePara;

    public WebElementFacade getUserSpan() {
        return userSpan;
    }

    public WebElementFacade getNameInput() {
        return nameInput;
    }

    public WebElementFacade getSubmitForm() {
        return submitForm;
    }

    public WebElementFacade getLoginLink() {
        return loginLink;
    }

    public WebElementFacade getResponsePara() {
        return responsePara;
    }
}
