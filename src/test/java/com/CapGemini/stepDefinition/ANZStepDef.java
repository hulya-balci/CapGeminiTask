package com.CapGemini.stepDefinition;

import com.CapGemini.pages.ANZPage;
import com.CapGemini.utilities.BrowserUtils;
import com.CapGemini.utilities.ConfigurationReader;
import com.CapGemini.utilities.Driver;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ANZStepDef {

    ANZPage anzPage=new ANZPage();

    @Given("Open chrome")
    public void openChrome() {
        Driver.get().manage().window().maximize();
    }


    @And("Navigate to anz")
    public void navigateToAnz() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("^User enters valid details$")
    public void user_enters_valid_details() {
        anzPage.single.click();
        anzPage.property.click();
        anzPage.annualIncome.sendKeys("80000");
        anzPage.annualOther.sendKeys("10000");
        anzPage.monthlyExp.sendKeys("500");
        anzPage.otherLoan.sendKeys("100");
        anzPage.creditCard.sendKeys("10000");
        anzPage.calculator.click();
    }

    @Then("^borrowing estimate is displayed correctly$")
    public void borrowing_estimate_is_displayed_correctly(){
        BrowserUtils.waitFor(2);
        String expectedAmount = "$482,000";
        String actualAmount=anzPage.borrowResult.getText();
        Assert.assertEquals(actualAmount,expectedAmount);
    }

    @When("^User clicks start over button$")
    public void user_clicks_start_over_button() {
        anzPage.startOver.click();
    }

    @Then("^Form is cleared$")
    public void form_is_cleared() {
        String resetvalue = "0";

       Assert.assertEquals((anzPage.annualIncome.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.annualOther.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.monthlyExp.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.otherLoan.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.otherLoan2.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.creditCard.getAttribute("value")),resetvalue);
       Assert.assertEquals((anzPage.homeLoan.getAttribute("value")),resetvalue);

    }

    @When("^User does not enter all details$")
    public void user_does_not_enter_all_details()  {
        anzPage.monthlyExp.sendKeys("100");
        anzPage.calculator.click();
    }

    @Then("^Correct error is displayed$")
    public void correct_error_is_displayed(){
        BrowserUtils.waitFor(2);
        Assert.assertTrue(anzPage.errorMsg.isDisplayed());
    }

    @Then("^Application should be closed$")
    public void application_should_be_closed(){
        Driver.get().quit();
    }

}