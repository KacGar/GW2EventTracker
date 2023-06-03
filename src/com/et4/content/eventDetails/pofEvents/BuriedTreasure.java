package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class BuriedTreasure extends Event {

    private final String eventName = "Buried Treasure";
    private final String waypoint = "[&BGsKAAA=]";
    private final String zone = "Desert Highlands";
    private final String area = "Crystal Desert";
    private final String description = "The Search for Buried Treasure is a meta event in Desert Highlands.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public BuriedTreasure() {
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
