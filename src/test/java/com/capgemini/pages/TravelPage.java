package com.capgemini.pages;

import com.capgemini.ourWebdriver.BrowserFactory;
import junit.framework.Assert;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TravelPage extends BasePage {

    //CSS Selectors
    private String travelTodaySelector = "[for=\"Today_TravelDate\"]";
    private String travelFromSelector = "#displayStationFrom";
    private String travelToSelector = "#displayStationTo";
    private String totalPriceSelector = "[data-test-id='TOTAL_PRICE']";
    private String secondClassSelector = "[data-test-id='SECOND_CLASS']";
    private String initialsSelector = "#PO_Initials_1";
    private String lastNameSelector = "#PO_LastName_1";
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
        browser.findElement(By.cssSelector(travelTodaySelector)).click();
    }

    public void travelFrom() {
        travelFrom(defaultFromLocation);
    }

    public void travelFrom(String fromLocation) {
        browser.findElement(By.cssSelector(travelFromSelector)).sendKeys(fromLocation);
    }

    public void travelTo() {
        travelTo(defaultToLocation);
    }

    public void travelTo(String toLocation) {
        browser.findElement(By.cssSelector(travelToSelector)).sendKeys(toLocation);
    }

    public void travelSecondClass() {
        browser.findElement(By.cssSelector(secondClassSelector)).click();
    }

    public void fillTravelDetails() {
        fillTravelDetails(defaultInitials, defaultLastName, defaultBirthdayDay, defaultBirthdayMonth, defaultBrithdayYear);
    }

    public void fillTravelDetails(String initials, String lastname, String birthdayDay, String birthdayMonth, String brithdayYear) {
        browser.findElement(By.cssSelector(initialsSelector)).sendKeys(initials);
        browser.findElement(By.cssSelector(lastNameSelector)).sendKeys(lastname);
        browser.findElement(By.cssSelector(birthdayDaySelectorPrefix + birthdayDay + birthdayDaySelectorSufix)).click();
        browser.findElement(By.cssSelector(birthdayMonthSelectorPrefix + birthdayMonth + birthdayMonthSelectorSufix)).click();
        browser.findElement(By.cssSelector(birthdayYearSelectorPrefix + brithdayYear + birthdayYearSelectorSufix)).click();
    }

    public void checkTicketPrice(String expectedPrice) {
        String actualPrice = browser.findElement(By.cssSelector(totalPriceSelector)).getText();
        Assert.assertEquals("Expected price <" + expectedPrice + "> did not meet actual price <" + actualPrice + ">", expectedPrice, actualPrice);
    }


}
