package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class MetalConcert extends Event {

    private final String eventName = "Metal Concert";
    private final String waypoint = "[&BPgLAAA=]";
    private final String zone = "Grothmar Valley";
    private final String area = "The Crag";
    private final String description = "A Concert for the Ages is a level 80 meta event that occurs in The Crag in Grothmar Valley at 20:00 Tyrian Time " +
            "(dusk) and rewards an Iron Legion Key. Help ensure Metal Legion's show goes smoothly, and don't forget to enjoy yourself!";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 40;

    public MetalConcert() {
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
