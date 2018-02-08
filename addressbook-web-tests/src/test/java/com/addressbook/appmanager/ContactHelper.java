package com.addressbook.appmanager;

import com.addressbook.model.ContactData;
import com.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.linkText("ADD_NEW"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='DELETE']"));
    }

    public void submitAlertMessage() {
        submitAlert();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt='EDIT']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        if(!isThereItemInGroupList(By.name("new_group"),contact.getGroup())) {
            new GroupHelper(driver).createGroup(new GroupData(contact.getGroup(),null,null));
            initContactCreation();
        }
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContactPage();
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public boolean isThereItemInGroupList(By locator, String group) {
        return isItemPresentInSelect(locator, group);
    }
}
