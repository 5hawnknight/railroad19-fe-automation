package com.rr19.assertions;

import com.rr19.models.ProjectOwner;
import com.rr19.pageobjects.cards.RecordCard;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordAssertions {
    private RecordCard recordCard;

    public RecordAssertions(RecordCard record) {
        this.recordCard = record;
    }

    public void verifyProjectOwner(ProjectOwner projectOwner) {
       assertThat(projectOwner.get()).isEqualTo(recordCard.readProjectOwner().get());
    }
}
