package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class DBS extends Event {

    private final String eventName = "Death-Branded Shatterer";
    private final String waypoint = "[&BJMLAAA=]";
    private final String zone = "Jahai Bluffs";
    private final String area = "Almorra's Stand";
    private final String description = "Destroy the Death-Branded Shatterer is a level 80 world boss group event that occurs in Almorra's Stand in Jahai Bluffs.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 15;

    public DBS() {
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
