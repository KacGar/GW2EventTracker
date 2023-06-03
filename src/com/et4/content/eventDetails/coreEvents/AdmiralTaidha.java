package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class AdmiralTaidha extends Event {

    private final String eventName = "Admiral Taidha";
    private final String waypoint = "[&BKgBAAA=]";
    private final String zone = "Bloodtide Coast";
    private final String area = "Laughing Gull Island";
    private final String description = "Kill Admiral Taidha Covington is a level 50 group event that occurs on Laughing Gull Island " +
                                        "in Bloodtide Coast. It is the final event of the area's The Campaign Against Taidha Covington " +
                                        "meta event.";

    private static final int[] scheduleHours = {0,3,6,9,12,15,18,21};
    private final int offsetMins = 0;

    public AdmiralTaidha() {
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
