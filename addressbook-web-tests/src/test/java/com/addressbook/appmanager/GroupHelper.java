package com.addressbook.appmanager;

import com.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void createGroup(GroupData group) {
        if (!isElementPresent(By.name("new")) || !driver.findElement(By.tagName("h1")).getText().equals("GROUPS")) {
            click(By.linkText("GROUPS"));
        }
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereGroupByName(String groupName) {
        return isElementPresent(By.xpath("//input[@title='Select (test1)']")); //TODO
    }

    public boolean isThereGroupByName1(String group) {
        for(WebElement element : driver.findElements(By.className("group"))) {
            if(element.getText().equals(group)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereGroupByName2(String group) {
        return driver.findElements(By.className("group")).stream().map(WebElement::getText).collect(Collectors.toList()).contains(group);
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
