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

        ContactData contact = new ContactData().withFirstName("Dmitriy")
                .withLastName("Monatique").withAddress("Boulevard of Hearts, 47")
                .withPhoneHome("+380732039090").withEmail("d.monatik@gmail.com").withGroup("test2");
        app.goTo().homePage();

        List<ContactData> before = app.contacts().list();

        app.contacts().create(contact);
        before.add(contact);

        app.goTo().homePage();

        List<ContactData> after = app.contacts().list();

        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        System.out.println(before);
        after.sort(byId);
        System.out.println(after);

        Assert.assertEquals(after, before);
    }
}
