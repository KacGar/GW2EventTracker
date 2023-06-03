package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class TripleTrouble extends Event {

    private final String eventName = "Triple Trouble";
    private final String waypoint = "[&BKoBAAA=]";
    private final String zone = "Bloodtide Coast";
    private final String area = "Firth of Revanion";
    private final String description = "Triple Trouble is a meta event that takes place in the Bloodtide Coast.";

    private static final int[] scheduleHours = {1,4,8,12,17,20};
    private final int offsetMins = 0;

    public TripleTrouble() {
        super();
        super.setEventName(this.eventName);
        super.setWaypoint(this.waypoint);
        super.setZone(this.zone);
        super.setArea(this.area);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setLocalSchedule(super.calculateSchedule());
        setupOffset();
    }

    private void setupOffset(){
        ZonedDateTime zdt = ZonedDateTime.now();
        int utcZoneOffset = (zdt.getOffset().get(ChronoField.OFFSET_SECONDS) / 60) / 60;
        int hour1 = scheduleHours[2] + utcZoneOffset;
        int hour2 = scheduleHours[3] + utcZoneOffset;
        int currHour = zdt.getHour();
        if (currHour > hour1 && currHour < hour2) {super.setOffsetMins(30);}
        else super.setOffsetMins(0);
    }
}
