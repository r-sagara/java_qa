package com.addressbook.tests.group;

        import com.addressbook.model.GroupData;
        import com.addressbook.tests.TestBase;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDelete() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);

    }
}
