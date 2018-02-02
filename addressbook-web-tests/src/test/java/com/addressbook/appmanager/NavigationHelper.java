package com.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.linkText("GROUPS"));
    }

    public void gotoAddNewContactPage() {
        click(By.linkText("ADD_NEW"));
    }

    public void gotoHomePage() {
        click(By.linkText("HOME"));
    }

    public void gotoNextBirthdays() {
        click(By.linkText("NEXT_BIRTHDAYS"));
    }

    public void gotoPage(String page) {
        click(By.linkText(page));
    }
}
