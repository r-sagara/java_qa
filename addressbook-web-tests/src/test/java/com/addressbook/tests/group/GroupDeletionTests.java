package com.addressbook.tests.group;

        import com.addressbook.model.GroupData;
        import com.addressbook.tests.TestBase;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDelete() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;

        app.group().delete(index);

        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
