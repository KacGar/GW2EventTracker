package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class OozePits extends Event {

    private final String eventName = "The Ooze Pit Trials";
    private final String waypoint = "[&BPgLAAA=]";
    private final String zone = "Grothmar Valley";
    private final String area = "Ascalon";
    private final String description = "The Ooze Pit Trials is a level 80 meta event that occurs in Grothmar Valley at 14:00 Tyrian Time " +
            "(40 minutes into daytime) and rewards a Blood Legion Key.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 5;

    public OozePits() {
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
