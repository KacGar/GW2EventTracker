package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Dragonstorm extends Event {

    private final String eventName = "Dragonstorm";
    private final String waypoint = "[&BAkMAAA=]";
    private final String zone = " Eye of the North";
    private final String area = "Shiverpeak Mountains";
    private final String description = "Dragonstorm is a group instance world boss version of the story chapter of the same name. It requires an access to Guild Wars 2: Path of Fire to enter.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public Dragonstorm() {
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
