package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "Dmitriy",
                    "Monatique",
                    "Boulevard of Hearts, 44",
                    "+380732039090",
                    "dima.monatique@gmail.com",
                    "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(
                "Dima",
                "MONATIK",
                "DM Street, 33",
                "+380992039090",
                "d.monatik@gmail.com",
                null);
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();

        before.remove(before.size() - 1);
        before.add(contact);

        List<ContactData> after = app.getContactHelper().getContactList();

        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);
    }
}
