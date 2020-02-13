package com.david.giczi.calendar.model;

import com.david.giczi.calendar.utils.MonthName;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author GicziD
 */
public class EventCreator {

    public static final List<Event> EVENTS = new ArrayList<>();
    private static final List<Event> EASTER_EVENTS = new ArrayList<>();

    public static void collectEvents(String eventName, String year, String month, String day) {

        if ("".equals(eventName) || "".equals(day)) {
            return;
        }

        Event inputEvent = new Event(eventName, Integer.parseInt(year),
                MonthName.getMonthNameByIndex(Integer.parseInt(month)), Integer.parseInt(day));

        if (!EVENTS.contains(inputEvent)) {
            EVENTS.add(inputEvent);
        }

        if ("Húsvét".equalsIgnoreCase(eventName)) {

            createBigFridayAndPentecostEvents(inputEvent);
            EASTER_EVENTS.forEach(event -> EVENTS.add(event));
        }

    }

    public static void addEventsToTheMonth(Month month) {

        EVENTS.stream().filter((event) -> (event.getYear() == month.getYear()
                && event.getMonth() == month.getMonthName())).forEachOrdered((event) -> {

            if ("".equals(month.getDays().get(event.getDay() - 1).getHolidayName())) {

                month.getDays().get(event.getDay() - 1).setHolidayName(event.getEventName());

            } else {

                month.getDays().get(event.getDay() - 1).setHolidayName(
                        month.getDays().get(event.getDay() - 1).getHolidayName()
                        + "&nbsp;&nbsp;&nbsp;<br>" + event.getEventName());

            }
        });

    }

    private static void createBigFridayAndPentecostEvents(Event easter) {

        GregorianCalendar g = new GregorianCalendar(easter.getYear(),
                MonthName.getMonthIndexByName(easter.getMonth()), easter.getDay());

        int dayOfEasterMondayInYear = g.get(Calendar.DAY_OF_YEAR);

        int dayOfEasterSundayInYear = dayOfEasterMondayInYear - 1;

        int dayOfBigFridayInYear = dayOfEasterMondayInYear - 3;

        int dayOfPentecostSundayInYear = dayOfEasterSundayInYear + 49;

        int dayOfPentecostMondayInYear = dayOfEasterSundayInYear + 50;

        g.set(Calendar.DAY_OF_YEAR, dayOfBigFridayInYear);

        Event bigFriday = new Event("Nagypéntek", easter.getYear(),
                MonthName.getMonthNameByIndex(g.get(Calendar.MONTH)), g.get(Calendar.DAY_OF_MONTH));

        EASTER_EVENTS.add(bigFriday);

        g.set(Calendar.DAY_OF_YEAR, dayOfEasterSundayInYear);

        Event easterSenday = new Event("Húsvét", easter.getYear(), MonthName.getMonthNameByIndex(g.get(Calendar.MONTH)), g.get(Calendar.DAY_OF_MONTH));

        EASTER_EVENTS.add(easterSenday);

        g.set(Calendar.DAY_OF_YEAR, dayOfPentecostSundayInYear);

        Event pentecostSunday = new Event("Pünkösd", easter.getYear(),
                MonthName.getMonthNameByIndex(g.get(Calendar.MONTH)), g.get(Calendar.DAY_OF_MONTH));

        EASTER_EVENTS.add(pentecostSunday);

        g.set(Calendar.DAY_OF_YEAR, dayOfPentecostMondayInYear);

        Event pentecostMonday = new Event("Pünkösd", easter.getYear(),
                MonthName.getMonthNameByIndex(g.get(Calendar.MONTH)), g.get(Calendar.DAY_OF_MONTH));

        EASTER_EVENTS.add(pentecostMonday);

    }

    public static void clearAddedEventNameFromTheMonthDays(Month month) {

        EVENTS.stream().filter(event -> event.getYear() == month.getYear()
                && event.getMonth() == month.getMonthName()).forEachOrdered(event -> event.setEventName(""));

    }

    public static void deleteAddedEventsFromTheMonths(Month month) {

        for (int i = EVENTS.size() - 1; i >= 0; i--) {

            if (EVENTS.get(i).getYear() == month.getYear() && EVENTS.get(i).getMonth() == month.getMonthName()) {

                EVENTS.remove(i);
            }
        }

    }

}
