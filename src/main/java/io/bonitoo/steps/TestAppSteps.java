package io.bonitoo.steps;

import io.bonitoo.pages.LoginPage;
import io.bonitoo.pages.PokladPage;
import io.bonitoo.pages.TestAppPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class TestAppSteps extends ScenarioSteps {

    TestAppPage testAppPage;
    LoginPage loginPage;
    PokladPage pokladPage;

    @Step
    public void open(){
        testAppPage.open();
    }

    @Step
    public void clickLogin(){
        testAppPage.getLoginLink().click();
    }

    @Step
    public void enterCredentials(String username, String password){
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
    }

    @Step
    public void clickLoginSubmit(){
        loginPage.getButton().click();
    }

    @Step
    public void verifyPokladPage(){
        pokladPage.getUserSpan().getText().equals("krtek");
        pokladPage.getImg().getAttribute("src").contains("banana.gif");
    }


}
