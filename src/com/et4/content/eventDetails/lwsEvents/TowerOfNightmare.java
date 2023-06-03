package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class TowerOfNightmare extends Event {

    private final String eventName = "The Tower of Nightmares";
    private final String waypoint = "[&BAkMAAA=]";
    private final String zone = "The Tower of Nightmares";
    private final String area = "Kryta";
    private final String description = "The Tower of Nightmares is a meta event that takes place in the instance of the same name.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 30;

    public TowerOfNightmare() {
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
