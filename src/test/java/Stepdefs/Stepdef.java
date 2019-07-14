package Stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Stepdef {
    
    @Given("^User inputs \"([^\"]*)\" password")
    public void userInputsPasswordAndPassword(String oldPassword, String newPassword) {
       
    }

    @Then("^Verify old password should match with system$")
    public void verifyOldPasswordShouldMatchWithSystem() {
    }

    @Then("^Verify the new password \"([^\"]*)\" is a valid password$")
    public void verifyTheNewPasswordIsAValidPassword() {
        
    }

    @Then("^Verify new password is not similar to old password <(\\d+)% match$")
    public void verifyNewPasswordIsNotSimilarToOldPasswordMatch(int percentMatch) {
    }
}
