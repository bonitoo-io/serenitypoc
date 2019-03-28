package io.bonitoo.stepDefinitions;

import io.bonitoo.steps.TestAppSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TestAppStepDefinitions {

    @Steps
    TestAppSteps testAppSteps;

    @Given("testapp is open")
    public void checkGoogleIsOpen(){

        testAppSteps.open();

    }

    @When("I click the login link")
    public void clickLogin(){
        testAppSteps.clickLogin();
    }

    @When("I enter the credentials '$username' and '$password'")
    public void enterCredentials(String username, String password){
        testAppSteps.enterCredentials(username, password);
    }

    @When("I click login submit")
    public void clickLoginSubmit(){
        testAppSteps.clickLoginSubmit();
    }

    @Then("the poklad is loaded")
    public void pokladLoaded(){

        testAppSteps.verifyPokladPage();

    }

}
