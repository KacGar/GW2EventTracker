package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class SooWon extends Event {

    private final String eventName = "Soo-Won";
    private final String waypoint = "[&BKIMAAA=]";
    private final String zone = "Dragon's End";
    private final String area = "Cantha";
    private final String description = "The Battle for the Jade Sea is a meta event that occurs in Dragon's End and culminates in the battle to subdue Soo-Won.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public SooWon() {
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
