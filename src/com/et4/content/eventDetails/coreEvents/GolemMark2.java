package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class GolemMark2 extends Event {

    private final String eventName = "Golem Mark 2";
    private final String waypoint = "[&BNQCAAA=]";
    private final String zone = "Mount Maelstrom";
    private final String area = "Whitland Flats";
    private final String description = "Defeat the Inquest's golem Mark II is a level 68 event that occurs in Whitland Flats at Mount Maelstrom.";

    private static final int[] scheduleHours = {2,5,8,11,14,17,20,23};
    private final int offsetMins = 0;

    public GolemMark2() {
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
