package com.rr19.tests.visual;

import org.testng.annotations.Test;

public class DashboardPage extends VisualTest {

    @Test
    public void verifyDashboard() {
        dashboard().visualCheckPoint();
        assertVisualCheckPoints();
    }
}
