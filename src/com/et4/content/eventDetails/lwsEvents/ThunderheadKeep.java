package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class ThunderheadKeep extends Event {

    private final String eventName = "Thunderhead Keep";
    private final String waypoint = "[&BLsLAAA=]";
    private final String zone = "Thunderhead Peaks";
    private final String area = "Thunderhead Keep";
    private final String description = "Thunderhead Keep is a meta event that takes place within the area of the same name in the northeastern part of the Thunderhead Peaks.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 45;

    public ThunderheadKeep() {
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
