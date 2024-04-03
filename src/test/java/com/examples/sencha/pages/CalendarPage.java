package com.examples.sencha.pages;

import com.codeborne.selenide.*;


import static com.codeborne.selenide.Selenide.*;

public class CalendarPage {
    private final SelenideElement
            titleText = $(".x-title-text"),
            createButton = $(".x-calendar-panel-create-button"),
            dayButton = $$(".x-calendar-panel-switcher a").first(),
            backButton = $("[data-componentid='button-1024']");

    private final ElementsCollection calendarEventTitles = $$(".x-calendar-event-title");


    public CalendarPage openCalendarPage() {
        open("https://examples.sencha.com/extjs/6.5.3/examples/calendar/frame-index.html");
        return this;
    }

    public void checkTitleText() {
        Selenide.sleep(10000);
        titleText.shouldHave(Condition.text("Ext JS Calendar"));
    }

    public void clickCreateButton() {
        createButton.shouldBe(Condition.visible).click();
    }

    public CalendarPage clickDay() {
        dayButton.click();
        return this;
    }

    public void clickBack(long countClick) {
        for (int i = 0; i < countClick; i++) {
            backButton.click();
        }

    }

    public void checkEventTitles(String titleFirst, String titleSecond) {
        calendarEventTitles.shouldHave(CollectionCondition.containExactTextsCaseSensitive(titleFirst, titleSecond));
    }

    public void printEventTitle() {
        calendarEventTitles.asFixedIterable().forEach(e -> System.out.println(e.getText()));
    }
}
