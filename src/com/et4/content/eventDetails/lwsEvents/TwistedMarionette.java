package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class TwistedMarionette extends Event {

    private final String eventName = "Twisted Marionette";
    private final String waypoint = "[&BAkMAAA=]";
    private final String zone = "Eye of the North";
    private final String area = "Shiverpeak Mountains";
    private final String description = "The Twisted Marionette is a group instance where the Twisted Marionette world boss is battled.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 0;

    public TwistedMarionette() {
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
