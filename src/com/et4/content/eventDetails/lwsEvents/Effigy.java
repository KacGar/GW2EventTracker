package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Effigy extends Event {

    private final String eventName = "Effigy";
    private final String waypoint = "[&BJMLAAA=]";
    private final String zone = "Grothmar Valley";
    private final String area = "Ascalon";
    private final String description = "Ceremony of the Sacred Flame is a level 80 meta event that starts at Eternal Cauldron in Grothmar Valley at 2:00 Tyrian Time " +
            "(25 minutes into nighttime) and rewards a Flame Legion Key. The goal is to light a large effigy which represents the past problems of the Flame Legion. " +
            "By burning it away, they have cleared away their issues and can move on towards peace and cooperation with the other Charr legions.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 10;

    public Effigy() {
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
