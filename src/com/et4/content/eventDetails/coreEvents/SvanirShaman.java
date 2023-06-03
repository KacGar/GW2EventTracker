package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class SvanirShaman extends Event {

    private final String eventName = "Svanir Shaman";
    private final String waypoint = "[&BMIDAAA=]";
    private final String zone = "Wayfarer Foothills";
    private final String area = "Hunter's Lake";
    private final String description = "Kill the Svanir shaman chief to break his control over the ice elemental is a " +
            "level 10 event in Wayfarer Foothills and the final event of The Frozen Maw meta. Upon completion, " +
            "a large chest spawns.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 15;

    public SvanirShaman() {
        super();
        super.setEventName(this.eventName);
        super.setWaypoint(this.waypoint);
        super.setZone(this.zone);
        super.setArea(this.area);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setOffsetMins(offsetMins);
        super.setLocalSchedule(super.calculateSchedule());

    }
}
