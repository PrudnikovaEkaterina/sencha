package com.examples.sencha.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarFormAdd {
    private final SelenideElement
            titleTextField = $$(".x-form-empty-field").get(0),
            dateFrom = $$(".x-form-date-trigger").get(0),
            dateTo = $$(".x-form-date-trigger").get(1),
            prevEl = $(".x-datepicker-prev.x-datepicker-arrow.x-unselectable"),
            checkboxAllDay = $(".x-form-checkbox"),
            timeFrom = $$(".x-form-time-trigger").get(0),
            timeTo = $$(".x-form-time-trigger").get(1),
            saveButton = $x("//span[text()='Save']");
    private final ElementsCollection
            boundListItem = $$(".x-boundlist-item"),
            datePickerDate = $$(".x-datepicker-date");


    public CalendarFormAdd setTitle(String title) {
        titleTextField.sendKeys(title);
        return this;
    }

    public CalendarFormAdd clickDateFrom() {
        dateFrom.click();
        return this;
    }

    public CalendarFormAdd clickDateTo() {
        dateTo.click();
        return this;
    }

    public CalendarFormAdd clickPrevEl() {
        prevEl.click();
        return this;
    }


    public CalendarFormAdd setDate(String date) {
        datePickerDate.findBy(Condition.text(date)).click();
        return this;
    }

    public CalendarFormAdd clickCheckboxAllDay() {
        checkboxAllDay.click();
        return this;
    }

    public CalendarFormAdd clickTimeFrom() {
        timeFrom.click();
        return this;
    }

    public CalendarFormAdd clickTimeTo() {
        timeTo.click();
        return this;
    }

    public CalendarFormAdd setTime(String time) {
        boundListItem.findBy(Condition.text(time)).click();
        return this;
    }

    public void clickSaveButton() {
        saveButton.click();
    }

}
