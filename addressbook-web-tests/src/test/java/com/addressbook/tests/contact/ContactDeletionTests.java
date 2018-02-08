package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.model.GroupData;
import com.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "Dmitriy",
                    "Monatique",
                    "+380732039090",
                    "d.monatik@gmail.com",
                    "test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitAlertMessage();
        app.getNavigationHelper().gotoHomePage();
    }
}
