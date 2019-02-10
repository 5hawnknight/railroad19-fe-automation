package com.rr19.tests.visual;

import com.rr19.models.Title;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RecordTitle extends VisualTest {

    private Title title;

    @Parameters("record.title")
    @BeforeMethod
    public void setup(String name) {
        title = () -> name;
    }

    @Test
    public void verifyDashboard() {
        dashboard().findRecord(title).visualCheckPoint();
        assertVisualCheckPoints();
    }
}
