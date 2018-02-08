package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contact = new ContactData(
                "Dmitriy",
                "Monatique",
                //"C:\\Users\\rkush\\Desktop\\ForTest\\68982_0.jpg",
                "+380732039090",
                "d.monatik@gmail.com",
                "test2");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoHomePage();
    }
}
