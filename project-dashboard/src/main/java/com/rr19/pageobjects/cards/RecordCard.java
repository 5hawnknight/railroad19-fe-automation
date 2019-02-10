package com.rr19.pageobjects.cards;

import com.applitools.eyes.selenium.fluent.Target;
import com.rr19.library.BrowserAPI;
import com.rr19.library.EyesHandler;
import com.rr19.library.LoadablePageObject;
import com.rr19.library.selenium.api.Locator;
import com.rr19.models.BudgetNumber;
import com.rr19.models.ProjectOwner;
import com.rr19.models.Status;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public interface RecordCard {

    Function<Locator, RecordCard> po = parent -> {
        class Instance implements RecordCard, LoadablePageObject<RecordCard>, BrowserAPI {

            private Function<String,Locator> build = value -> chainCss.apply(parent).apply(value);
            private Locator moreInfoButton      = build.apply("[data-tea-more-info-button]");
            private Locator ownerEditButton     = build.apply("[data-tea-project-owner-edit-button]");
            private Locator ownerLabel          = build.apply("[data-tea-project-owner-label");
            private Locator ownerEditTextBox    = build.apply("[data-tea-project-owner-textbox]");
            private Locator budgetEditButton    = build.apply("[data-tea-budget-edit-button]");
            private Locator budgetLabel         = build.apply("[data-tea-budget-label");
            private Locator budgetTextBox       = build.apply("[data-tea-budget-textbox]");
            private Locator statusEditButton    = build.apply("[data-tea-status-edit-button]");
            private Locator statusLabel         = build.apply("[data-tea-status-label");
            private Locator statusTextBox       = build.apply("[data-tea-status-textbox]");

            private Function<Locator,Function<Locator, Consumer<String>>> update = button -> textbox -> value -> {
                click.apply(button);
                toBeClickable
                        .andThen(clear)
                        .andThen(typeText.apply(value)).apply(textbox);
                click.apply(button);
            };

            @Override
            public void pageObjectInitializer() {
                List.of(ownerEditButton,budgetEditButton,statusEditButton,moreInfoButton)
                        .forEach(e -> toBeClickable.apply(e));
            }

            @Override
            public RecordCard updateProjectOwner(ProjectOwner owner) {
                update.apply(ownerEditButton).apply(ownerEditTextBox).accept(owner.get());
                return this;
            }

            @Override
            public RecordCard updateBudget(BudgetNumber number) {
                update.apply(budgetEditButton).apply(budgetTextBox).accept(number.get());
                return this;
            }

            @Override
            public RecordCard updateStatus(Status status) {
                update.apply(statusEditButton).apply(statusTextBox).accept(status.get());
                return this;
            }

            @Override
            public ProjectOwner readProjectOwner() {
                return () -> getText.apply(ownerLabel);
            }

            @Override
            public BudgetNumber readBudgetNumber() {
                return () -> getText.apply(budgetLabel);
            }

            @Override
            public Status readStatus() {
                return () -> getText.apply(statusLabel);
            }

            @Override
            public RecordCard visualCheckPoint() {
                EyesHandler.eyes().check("RecordCard", Target.region(parent.element())
                            .layout()
                            .ignoreCaret(true));
               return this;
            }
        }
    return new Instance().get();
    };

    RecordCard updateProjectOwner(ProjectOwner projectOwner);
    RecordCard updateBudget(BudgetNumber number);
    RecordCard updateStatus(Status status);
    ProjectOwner readProjectOwner();
    BudgetNumber readBudgetNumber();
    Status readStatus();
    RecordCard visualCheckPoint();
}