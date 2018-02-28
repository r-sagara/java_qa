package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "Dmitriy",
                    "Monatique",
                    "Boulevard of Hearts, 44",
                    "+380732039090",
                    "d.monatik@gmail.com",
                    "test1"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitAlertMessage();
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }
}
