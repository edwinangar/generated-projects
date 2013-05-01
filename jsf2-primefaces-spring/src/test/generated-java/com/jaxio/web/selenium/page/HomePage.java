/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/HomePage.p.vm.java
 */
package com.jaxio.web.selenium.page;

import static org.openqa.selenium.By.cssSelector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Page;
import com.jaxio.web.selenium.support.Client;

@Page
public class HomePage {
    @FindBy(id = "form:selectAccount")
    public WebElement accountLink;
    @FindBy(id = "form:switchToFrench")
    public WebElement switchToFrench;
    @FindBy(id = "form:switchToEnglish")
    public WebElement switchToEnglish;
    @FindBy(id = "form:messages")
    public WebElement messagesPanel;

    protected Client client;

    public void switchToEnglish() {
        client.click(switchToEnglish);
    }

    public void switchToFrench() {
        client.click(switchToFrench);
    }

    public void accounts() {
        client.click(accountLink);
    }

    public void hasText(String... values) {
        for (String value : values) {
            client.text(value);
        }
    }

    public void hasMessage(String... values) {
        for (String value : values) {
            client.text(messagesPanel, value);
        }
    }

    protected void clickEdit(String value) {
        client.click(cssSelector("a[title=\"Edit " + value + "\"]"));
    }

    protected void clickAdd(String value) {
        client.click(cssSelector("a[title=\"Add " + value + "\"]"));
    }

    protected void clickDelete(String value) {
        client.click(cssSelector("a[title=\"Remove " + value + "\"]"));
    }

    protected void clickSelect(String value) {
        client.click(cssSelector("a[title=\"Select " + value + "\"]"));
    }
}