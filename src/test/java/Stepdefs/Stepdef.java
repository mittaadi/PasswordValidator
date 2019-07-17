package Stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.ConnectingDatabase;
import utils.PropertyReader;

import java.sql.SQLException;

public class Stepdef {
    public String assignOldPassword = null;
    public String assignNewPassword = null;

    @Given("^User inputs \"([^\"]*)\" password")
    public void userInputsPasswordAndPassword(String oldPassword) {
        assignOldPassword = oldPassword;
    }

    @Then("^Verify old password should match with system$")
    public void verifyOldPasswordShouldMatchWithSystem() throws SQLException {
        PropertyReader pr = new PropertyReader();
        String systemPassword;
        if ((systemPassword = pr.readProperty("systemPassword")) != null)
            Assert.assertEquals(systemPassword, assignOldPassword);
        else if ((systemPassword = new ConnectingDatabase().connectDB("userName")) != null)
            Assert.assertEquals(systemPassword, assignOldPassword);
    }

    @Then("^Verify the new password \"([^\"]*)\" is a valid password$")
    public void verifyTheNewPasswordIsAValidPassword(String newPassword) {
        assignNewPassword=newPassword;
        Assert.assertTrue(new PasswordValidator().checkPasswordIsValid(newPassword));
    }

    @Then("^Verify new password is not similar to old password <(\\d+)% match$")
    public void verifyNewPasswordIsNotSimilarToOldPasswordMatch(int percentMatch) {
        Assert.assertTrue(new PasswordComparator().changePassword(assignOldPassword,assignNewPassword));
        Assert.assertTrue(new PasswordComparator().similarityCheck(assignOldPassword,assignNewPassword,percentMatch));
    }

    @Then("Verify new password is similar to old password for less than {int}% match")
    public void verifyNewPasswordIsSimilarToOldPasswordForLessThanMatch(Integer percentMatch) {
        Assert.assertTrue(new PasswordComparator().changePassword(assignOldPassword,assignNewPassword));
        Assert.assertTrue(new PasswordComparator().similarityCheck(assignOldPassword,assignNewPassword,percentMatch));
        throw new cucumber.api.PendingException();
    }
}
