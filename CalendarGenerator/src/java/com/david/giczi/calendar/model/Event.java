package com.david.giczi.calendar.model;

import com.david.giczi.calendar.utils.MonthName;
import java.util.Objects;

/**
 *
 * @author GicziD
 */
public class Event {

    private String eventName;
    private final int year;
    private final MonthName month;
    private final int day;

    public Event(String eventName, int year, MonthName month, int day) {
        this.eventName = eventName;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getEventName() {
        return eventName;
    }

    public int getYear() {
        return year;
    }

    public MonthName getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.eventName);
        hash = 23 * hash + this.year;
        hash = 23 * hash + Objects.hashCode(this.month);
        hash = 23 * hash + this.day;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (!Objects.equals(this.eventName, other.eventName)) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "eventName=" + eventName + ", year=" + year + ", month=" + month + ", day=" + day + '}';
    }

}
