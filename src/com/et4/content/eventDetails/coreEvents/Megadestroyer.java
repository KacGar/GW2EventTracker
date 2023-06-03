package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class Megadestroyer extends Event {

    private final String eventName = "Megadestroyer";
    private final String waypoint = "[&BM0CAAA=]";
    private final String zone = "Mount Maelstrom";
    private final String area = "Maelstrom's Bile";
    private final String description = "Kill the megadestroyer before it blows everyone up is a level 66 group event " +
            "in Mount Maelstrom. It is the final event of the meta event The Battle for Mount Maelstrom.";

    private static final int[] scheduleHours = {0,3,6,9,12,15,18,21};
    private final int offsetMins = 30;

    public Megadestroyer() {
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
