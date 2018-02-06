package com.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("GROUPS"));
    }

    public void gotoAddNewContactPage() {
        click(By.linkText("ADD_NEW"));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("HOME"));
    }

    public void gotoNextBirthdays() {
        click(By.linkText("NEXT_BIRTHDAYS"));
    }

    public void gotoPage(String page) {
        click(By.linkText(page));
    }
}
