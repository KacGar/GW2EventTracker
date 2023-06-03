package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class NoransHomestead extends Event {

    private final String eventName = "Noran's Homestead";
    private final String waypoint = "[&BK8JAAA=]";
    private final String zone = "Lake Doric";
    private final String area = "Harvest Cascades";
    private final String description = "White Mantle Control: Noran's Homestead is a meta event that takes place in the Harvest Cascades in Lake Doric.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 30;

    public NoransHomestead() {
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
