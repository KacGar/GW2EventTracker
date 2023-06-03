package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class OilFloes extends Event {

    private final String eventName = "The Oil Floes";
    private final String waypoint = "[&BKYLAAA=]";
    private final String zone = "Thunderhead Peaks";
    private final String area = "Dredgeways";
    private final String description = "The Oil Floes is a level 80 meta event that occurs in Ice Floe in Thunderhead Peaks.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 45;

    public OilFloes() {
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
