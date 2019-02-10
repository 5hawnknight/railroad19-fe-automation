package com.rr19.tests.visual;

import org.testng.annotations.Test;

public class StatisticsCard extends VisualTest {

    @Test
    public void verifyStatisticsCard() {
        dashboard().statistics().visualCheckPoint();
        assertVisualCheckPoints();
    }
}