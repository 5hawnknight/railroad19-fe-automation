package com.rr19.tests.visual;

import com.github.javafaker.Faker;
import com.rr19.models.ProjectOwner;
import com.rr19.models.Title;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateUserMessage extends VisualTest {

    private Title title;
    private ProjectOwner projectOwner;

    @Parameters("record.title")
    @BeforeMethod
    public void setup(String name) {
        title = () -> name;
        var randomName = new Faker().name().fullName();
        projectOwner = () -> randomName;
    }

    @Test
    public void verifyUpdateMessage() {
        dashboard().findRecord(title).updateProjectOwner(projectOwner);
        dashboard().visualCheckPoint();
        assertVisualCheckPoints();
    }
}