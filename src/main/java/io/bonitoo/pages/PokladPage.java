package io.bonitoo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PokladPage extends PageObject {

     @FindBy(css = "span#username")
     WebElementFacade userSpan;

     @FindBy(css = "img")
     WebElementFacade img;

    public WebElementFacade getUserSpan() {
        return userSpan;
    }

    public WebElementFacade getImg() {
        return img;
    }
}
