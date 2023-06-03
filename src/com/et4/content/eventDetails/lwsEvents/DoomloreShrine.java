package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class DoomloreShrine extends Event {

    private final String eventName = "Doomlore Shrine";
    private final String waypoint = "[&BA4MAAA=]";
    private final String zone = "Grothmar Valley";
    private final String area = "Ascalon";
    private final String description = "The Haunting of Doomlore Shrine is a level 80 meta event that occurs in Grothmar Valley at 8:00 Tyrian Time " +
            "(10 minutes into daytime) and rewards an Ash Legion Key.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 38;

    public DoomloreShrine() {
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
