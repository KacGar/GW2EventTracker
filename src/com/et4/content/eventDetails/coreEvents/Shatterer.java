package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class Shatterer extends Event {

    private final String eventName = "The Shatterer";
    private final String waypoint = "[&BE4DAAA=]";
    private final String zone = "Blazeridge Steppes";
    private final String area = "Lowland Burns";
    private final String description = "Slay the Shatterer is a group event that occurs in the Lowland Burns in Blazeridge Steppes. It occurs as the final part of the meta event Kralkatorrik's Legacy.";

    private static final int[] scheduleHours = {1,4,7,10,13,16,19,22};
    private final int offsetMins = 0;

    public Shatterer() {
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
