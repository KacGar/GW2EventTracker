package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Drakkar extends Event {

    private final String eventName = "Drakkar";
    private final String waypoint = "[&BPgLAAA=]";
    private final String zone = "Bjora Marches";
    private final String area = "Fractured Lake";
    private final String description = "Champion of the Ice Dragon is a level 80 meta event occurring around Fractured Lake in Bjora Marches.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 5;

    public Drakkar() {
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
