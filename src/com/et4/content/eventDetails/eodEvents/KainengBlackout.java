package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class KainengBlackout extends Event {

    private final String eventName = "Kaineng Blackout";
    private final String waypoint = "[&BBkNAAA=]";
    private final String zone = "New Kaineng City";
    private final String area = "Cantha";
    private final String description = "Kaineng Blackout is a level 80 meta event that occurs in New Kaineng City.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 0;

    public KainengBlackout() {
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
