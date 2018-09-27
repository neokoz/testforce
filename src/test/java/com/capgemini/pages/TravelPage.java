package com.capgemini.pages;

import com.capgemini.ourWebdriver.BrowserFactory;
import junit.framework.Assert;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TravelPage extends BasePage {

    //CSS Selectors
    private By travelTodaySelector = By.cssSelector("[for=\"Today_TravelDate\"]");
    private By travelFromSelector = By.cssSelector("#displayStationFrom");
    private By travelToSelector = By.cssSelector("#displayStationTo");
    private By totalPriceSelector = By.cssSelector("[data-test-id='TOTAL_PRICE']");
    private By secondClassSelector = By.cssSelector("[data-test-id='SECOND_CLASS']");
    private By initialsSelector = By.cssSelector("#PO_Initials_1");
    private By lastNameSelector = By.cssSelector("#PO_LastName_1");
    private String birthdayDaySelectorPrefix = "[name='PO_BirthDate_1'] .inputfield__selectbox--birthdateDay [value='";
    private String birthdayDaySelectorSufix = "']";
    private String birthdayMonthSelectorPrefix = "[name='PO_BirthDate_1'] .inputfield__selectbox--birthdateMonth [value='";
    private String birthdayMonthSelectorSufix = "']";
    private String birthdayYearSelectorPrefix = "[name='PO_BirthDate_1'] .inputfield__selectbox--birthdateYear [value='";
    private String birthdayYearSelectorSufix = "']";

    //Default values
    private String defaultFromLocation = "Amsterdam Centraal";
    private String defaultToLocation = "Utrecht Centraal";
    private String defaultInitials = "K.";
    private String defaultLastName = "Tester";
    private String defaultBirthdayDay = "14";
    private String defaultBirthdayMonth = "8";
    private String defaultBrithdayYear = "1975";

    public TravelPage() throws MalformedURLException {
    }

    public void travelToday() {
        browser.findElement(travelTodaySelector).click();
    }

    public void travelFrom() {
        travelFrom(defaultFromLocation);
    }

    public void travelFrom(String fromLocation) {
        browser.findElement(travelFromSelector).sendKeys(fromLocation);
    }

    public void travelTo() {
        travelTo(defaultToLocation);
    }

    public void travelTo(String toLocation) {
        browser.findElement(travelToSelector).sendKeys(toLocation);
    }

    public void travelSecondClass() {
        browser.findElement(secondClassSelector).click();
    }

    public void fillTravelDetails() {
        fillTravelDetails(defaultInitials, defaultLastName, defaultBirthdayDay, defaultBirthdayMonth, defaultBrithdayYear);
    }

    public void fillTravelDetails(String initials, String lastname, String birthdayDay, String birthdayMonth, String brithdayYear) {
        browser.findElement(initialsSelector).sendKeys(initials);
        browser.findElement(lastNameSelector).sendKeys(lastname);
        browser.findElement(By.cssSelector(birthdayDaySelectorPrefix + birthdayDay + birthdayDaySelectorSufix)).click();
        browser.findElement(By.cssSelector(birthdayMonthSelectorPrefix + birthdayMonth + birthdayMonthSelectorSufix)).click();
        browser.findElement(By.cssSelector(birthdayYearSelectorPrefix + brithdayYear + birthdayYearSelectorSufix)).click();
    }

    public void checkTicketPrice(String expectedPrice) {
        String actualPrice = browser.findElement(totalPriceSelector).getText();
        Assert.assertEquals("Expected price <" + expectedPrice + "> did not meet actual price <" + actualPrice + ">", expectedPrice, actualPrice);
    }


}
