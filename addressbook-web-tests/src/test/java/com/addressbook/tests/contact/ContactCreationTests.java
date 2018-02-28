package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        ContactData contact = new ContactData(
                "Dmitriy",
                "Monatique",
                "Boulevard of Hearts, 47",
                "+380732039090",
                "d.monatik@gmail.com",
                "test2");
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().createContact(contact);
        before.add(contact);

        app.getNavigationHelper().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        System.out.println(before);
        after.sort(byId);
        System.out.println(after);

        Assert.assertEquals(after, before);
    }
}
