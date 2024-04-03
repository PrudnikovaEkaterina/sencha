package com.examples.sencha.web_tests.calendarTests;

import com.codeborne.selenide.Configuration;
import com.examples.sencha.healpers.DateHelper;
import com.examples.sencha.pages.CalendarPage;
import com.examples.sencha.pages.components.CalendarFormAdd;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class CalendarTests {
    CalendarPage calendarPage = new CalendarPage();
    CalendarFormAdd calendarFormAdd = new CalendarFormAdd();

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1200x800";
        Configuration.pageLoadStrategy = "eager";
        System.setProperty("webdriver.chrome.driver", "/home/user/chromedriver");
    }

    @BeforeEach
    public void openCalendarFormAdd() {
        calendarPage
                .openCalendarPage()
                .checkTitleText();

    }

    @Test
    public void addEvents() {
        String date = "31";
        String timeFrom = "10:00 AM";
        String timeTo = "11:00 AM";
        long diffDay = DateHelper.getDaysDifferent(LocalDate.of(2024, 3, 31));
        String titleFirst = "Add event first";
        String titleSecond = "Add event second";

        calendarPage.clickCreateButton();

        calendarFormAdd
                .setTitle(titleFirst)
                .clickDateFrom()
                .clickPrevEl()
                .setDate(date)
                .clickDateTo()
                .clickPrevEl()
                .setDate(date)
                .clickCheckboxAllDay()
                .clickTimeFrom()
                .setTime(timeFrom)
                .clickTimeTo()
                .setTime(timeTo)
                .clickSaveButton();

        calendarPage.clickCreateButton();

        calendarFormAdd
                .setTitle(titleSecond)
                .clickDateFrom()
                .clickPrevEl()
                .setDate(date)
                .clickDateTo()
                .clickPrevEl()
                .setDate(date)
                .clickCheckboxAllDay()
                .clickTimeFrom()
                .setTime(timeFrom)
                .clickTimeTo()
                .setTime(timeTo)
                .clickSaveButton();

        calendarPage
                .clickDay()
                .clickBack(diffDay);

        calendarPage.checkEventTitles(titleFirst, titleSecond);

        calendarPage.printEventTitle();
    }

}
