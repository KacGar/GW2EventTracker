package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class SerpentsIre extends Event {

    private final String eventName = "Serpents' Ire";
    private final String waypoint = "[&BHQKAAA=]";
    private final String zone = "Domain of Vabbi";
    private final String area = "Crystal Desert";
    private final String description = "Serpents' Ire is a meta event that takes place in the Branded eastern part of Domain of Vabbi.";

    private static final int[] scheduleHours = {2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 30;

    public SerpentsIre() {
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
