package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class JununduRising extends Event {

    private final String eventName = "Junundu Rising";
    private final String waypoint = "[&BMEKAAA=]";
    private final String zone = "The Desolation";
    private final String area = "The Shattered Ravines";
    private final String description = "Junundu Rising is a meta event in the Desolation.";

    private static final int[] scheduleHours = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    private final int offsetMins = 30;

    public JununduRising() {
        super();
        super.setEventName(this.eventName);
        super.setWaypoint(this.waypoint);
        super.setZone(this.zone);
        super.setArea(this.area);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setLocalSchedule(super.calculateSchedule());
        super.setOffsetMins(offsetMins);

    }
}
