package com.addressbook.tests.contact;

import com.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitAlertMessage();
        app.getNavigationHelper().gotoHomePage();
    }
}
