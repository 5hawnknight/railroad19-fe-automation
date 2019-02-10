package com.rr19.tests.visual;

import com.rr19.models.SearchTerm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleSearch extends VisualTest {

    private SearchTerm searchTerm;

    @Parameters("term")
    @BeforeMethod
    public void setup(String term) {
        searchTerm = () -> term;
    }

    @Test
    public void verifyDashboard() {
        dashboard().search().with(searchTerm)
                .dashboard().visualCheckPoint();
        assertVisualCheckPoints();
    }
}