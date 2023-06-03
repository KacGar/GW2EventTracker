package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class NewLoamhurst extends Event {

    private final String eventName = "New Loamhurst";
    private final String waypoint = "[&BLQJAAA=]";
    private final String zone = "Lake Doric";
    private final String area = "New Loamhurst";
    private final String description = "White Mantle Control: New Loamhurst is a meta event that takes place in the New Loamhurst in Lake Doric.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 45;

    public NewLoamhurst() {
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
