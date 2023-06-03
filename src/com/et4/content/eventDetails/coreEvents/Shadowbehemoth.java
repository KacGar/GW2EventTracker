package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class Shadowbehemoth extends Event {

    private final String eventName = "Shadow Behemoth";
    private final String waypoint = "[&BPcAAAA=]";
    private final String zone = "Queensdale";
    private final String area = "Godslost Swamp";
    private final String description = "Defeat the shadow behemoth is a level 15 event that takes place " +
            "in Godslost Swamp in Queensdale. While being fought, underworld portals appear, spawning Shades and Aatxes.";

    private static final int[] scheduleHours = {1,3,5,7,9,1,13,15,17,19,21,23};
    private final int offsetMins = 45;

    public Shadowbehemoth() {
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
