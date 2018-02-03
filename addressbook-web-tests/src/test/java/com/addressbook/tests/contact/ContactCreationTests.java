package com.addressbook.tests.contact;

import com.addressbook.model.ContactData;
import com.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoAddNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData(
                "Dmitriy",
                "Monatique",
                //"C:\\Users\\rkush\\Desktop\\ForTest\\68982_0.jpg",
                "+380732039090",
                "dima.monatik@gmail.com"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}
