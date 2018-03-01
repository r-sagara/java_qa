package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contacts().list().size() == 0) {
            app.contacts().create(new ContactData().withFirstName("Dmitriy")
                    .withLastName("Monatique").withAddress("Boulevard of Hearts, 47")
                    .withPhoneHome("+380732039090").withEmail("d.monatik@gmail.com").withGroup("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        List<ContactData> before = app.contacts().list();
        int index = before.size() - 1;

        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withFirstName("Dima").withLastName("MONATIK")
                .withAddress("DM Street, 33").withPhoneHome("+380992039090").withEmail("d.monatik@gmail.com");

        app.contacts().modify(index, contact);

        before.remove(index);
        before.add(contact);

        List<ContactData> after = app.contacts().list();

        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
