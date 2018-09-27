package com.capgemini.steps;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import com.capgemini.ourWebdriver.TearDown;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.TravelPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    private OurWebDriver browser;
    private TearDown tearDown;
    private BasePage basePage;
    private TravelPage travelPage;

    public NS() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();
        basePage = new BasePage(browser);
        travelPage = new TravelPage();
    }


    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        basePage.goToMainPage();
    }

    @And("^I clicked accept in cookie popup$")
    public void iClickedAcceptInCookiePopup() throws Throwable {
        basePage.acceptCookies();
    }

    @When("^I choose to travel today$")
    public void iChooseToTravelToday() throws Throwable {
        travelPage.travelToday();
    }


    @And("^I travel from Amsterdam$")
    public void iTravelFromAmsterdam() throws Throwable {
        travelPage.travelFrom(); //Since Amsterdam is default location, use this constructor
    }

    @Given("^I am at the mainpage$")
    public void iAmAtTheMainpage() throws Throwable {
        basePage.goToMainPage();
        basePage.acceptCookies();
    }

    @When("^I travel from Amsterdam today$")
    public void iTravelFromAmsterdamToday() throws Throwable {
        travelPage.travelToday();
        travelPage.travelFrom(); //Since Amsterdam is default location, use this constructor
    }

    @When("^I book a standard ticket$")
    public void iBookAStandardTicket() throws Throwable {
        travelPage.travelToday();
        travelPage.travelFrom(); //Standard ticket, use this constructor
        travelPage.travelTo(); //Standard ticket, use this constructor
        travelPage.travelSecondClass();
        travelPage.fillTravelDetails();
    }

    @Then("^the ticket price is \"([^\"]*)\"$")
    public void theTicketPriceIs(String expectedPrice) throws Throwable {
        travelPage.checkTicketPrice(expectedPrice);
    }
}
