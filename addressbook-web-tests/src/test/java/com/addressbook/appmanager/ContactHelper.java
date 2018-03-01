package com.addressbook.appmanager;

import com.addressbook.model.ContactData;
import com.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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
        type(By.name("address"),contactData.getAddress());
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

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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

    public void create(ContactData contact) {
        initContactCreation();
        if(!isThereItemInGroupList(By.name("new_group"),contact.getGroup())) {
            new GroupHelper(driver).create(new GroupData().withName(contact.getGroup()));
            initContactCreation();
        }
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContactPage();
    }

    public void modify(int index, ContactData contact) {
        selectContact(index);
        initContactModification();
        fillContactForm(contact,false);
        submitContactModification();
        returnToContactPage();
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public boolean isThereItemInGroupList(By locator, String group) {
        return isItemPresentInSelect(locator, group);
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElement(By.id("maintable")).findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String name1 = element.findElement(By.xpath("td[3]")).getText();
            String name2 = element.findElement(By.xpath("td[2]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            String email = element.findElement(By.xpath("td[5]")).getText();
            String phone = element.findElement(By.xpath("td[6]")).getText();
            contacts.add(new ContactData()
                    .withId(id).withFirstName(name1).withLastName(name2)
                    .withAddress(address).withEmail(email).withPhoneHome(phone));
        }
        return contacts;
    }
}
