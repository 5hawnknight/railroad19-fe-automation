package com.rr19.assertions;

import com.rr19.pageobjects.cards.RecordCard;

public class Assertions {
    public RecordAssertions record(RecordCard record) {
        return new RecordAssertions(record);
    }
}
