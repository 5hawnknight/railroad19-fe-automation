package com.rr19.tests.visual;

import org.testng.annotations.Test;

public class SearchCard extends VisualTest {

    @Test
    public void verifySearchCard() {
        dashboard().search().visualCheckPoint();
        assertVisualCheckPoints();
    }
}