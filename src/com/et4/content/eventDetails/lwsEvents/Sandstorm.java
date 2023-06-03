package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Sandstorm extends Event {

    private final String eventName = "Sandstorm";
    private final String waypoint = "[&BIAHAAA=]";
    private final String zone = "Dry Top";
    private final String area = "Maguuma Wastes";
    private final String description = "Sandstorm! is a meta event that takes place in Dry Top. It starts every xx:40 of each hour and lasts for 20 minutes. " +
            "Events cycle every 10 minutes, spawning Champions depending on the Favor of the Zephyrites accumulated during the previous meta-event. " +
            "Once the 20 minutes have passed, the Crash Site meta-event starts over.";

    private static final int[] scheduleHours = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    private final int offsetMins = 40;

    public Sandstorm() {
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
