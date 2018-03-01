package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        if (app.contacts().list().size() == 0) {
            app.contacts().create(new ContactData().withFirstName("Dmitriy")
                    .withLastName("Monatique").withAddress("Boulevard of Hearts, 47")
                    .withPhoneHome("+380732039090").withEmail("d.monatik@gmail.com").withGroup("test1"));
        }

        List<ContactData> before = app.contacts().list();

        int index = before.size() - 1;
        app.contacts().selectContact(index);
        app.contacts().deleteSelectedContacts();
        app.contacts().submitAlertMessage();
        app.goTo().homePage();

        List<ContactData> after = app.contacts().list();

        before.remove(index);
        Assert.assertEquals(after, before);
    }
}
