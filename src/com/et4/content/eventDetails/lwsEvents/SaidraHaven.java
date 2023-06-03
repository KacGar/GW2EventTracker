package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class SaidraHaven extends Event {

    private final String eventName = "Saidra's Haven";
    private final String waypoint = "[&BK0JAAA=]";
    private final String zone = "Lake Doric";
    private final String area = "Harvest Cascades";
    private final String description = "White Mantle Control: Saidra's Haven is a meta event that takes place in Saidra's Haven in Lake Doric.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public SaidraHaven() {
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
