package com.capgemini.pages;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class BasePage {

    protected OurWebDriver browser;

    //Main page properties
    private String baseUrl = "https://www.ns.nl/producten/en/s/enkele-reis";

    //Main selectors
    private By iframeCookieSelector = By.cssSelector(".r42CookieBar");
    private By iframeCookieButtonSelector = By.cssSelector(".button.accept");

    public BasePage() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();
    }

    //Constructor with ourWebdriver
    public BasePage(OurWebDriver ourWebDriver) {
        this.browser = ourWebDriver;
    }

    //Getter and setters
    public OurWebDriver getBrowser() {
        return browser;
    }

    public void setBrowser(OurWebDriver browser) {
        this.browser = browser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    //Real methods
    public void goToMainPage() {
        browser.get(baseUrl);
    }

    public void acceptCookies() {
        try {
            WebElement iframe = browser.waitForElement(iframeCookieSelector);
            browser.switchTo().frame(iframe);
            browser.findElement(iframeCookieButtonSelector).click();
            browser.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
