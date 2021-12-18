package com.CapGemini.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ANZPage extends BasePage {

   @FindBy(id = "application_type_single")
    public WebElement single;

   @FindBy(xpath = "//label[contains(@for,'home')]")
    public WebElement property;

    @FindBy(xpath = "//input[@aria-labelledby='q2q1']")
    public WebElement annualIncome;

    @FindBy(xpath = "//input[@aria-labelledby='q2q2']")
    public WebElement annualOther;

    @FindBy(xpath = "//input[contains(@id,'expenses')]")
    public WebElement monthlyExp;

    @FindBy(xpath = "//input[contains(@id,'otherloans')]")
    public WebElement otherLoan;

    @FindBy(xpath = "//input[@id='homeloans']")
    public WebElement homeLoan;

    @FindBy(xpath = "//input[contains(@aria-labelledby,'q3q4')]")
    public WebElement otherLoan2;

    @FindBy(xpath = "//input[@id='credit']")
    public WebElement creditCard;

    @FindBy(xpath = "//button[contains(@class,'calculate')]")
    public WebElement calculator;

    @FindBy(id = "borrowResultTextAmount")
    public WebElement borrowResult;

    @FindBy(xpath = "(//button[@class='start-over'])[1]")
    public  WebElement startOver;

    @FindBy(xpath = "(//div[@aria-atomic='true'])[2]")
    public WebElement errorMsg;






}
