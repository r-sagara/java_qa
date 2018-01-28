package com.java_qa.task2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    DecimalFormat df = new DecimalFormat("#.##");

    @Test
    public void testDistance1() {
        Point p1 = new Point(2.3,5.2);
        Point p2 = new Point(2.84, 10.1);

        Assert.assertEquals(df.format(p1.distance(p2)),df.format(4.93));
    }

    @Test
    public void testDistance2() {
        Assert.assertEquals(df.format(new Point(4.4,5.5).distance(new Point(2.2,3.3))),
                df.format(3.11));
    }
}
