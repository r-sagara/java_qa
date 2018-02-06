package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "Valeriy",
                "Meladze",
                "+79124505050",
                "mar.meladze@gmail.com",
                null),
                false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
