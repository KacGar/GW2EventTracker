package com.et4.content.eventDetails.hotEvents;

import com.et4.content.Event;

public class Tarir extends Event {

    private final String eventName = "Octovine";
    private final String waypoint = "[&BAIIAAA=]";
    private final String zone = "Auric Basin";
    private final String area = "Heart of Maguuma";
    private final String description = "Battle in Tarir is a map meta event that occurs in Auric Basin. Mordrem have attacked the city of Tarir and the Exalted are defending " +
            "their city using various trials to find warriors to help them in their defense of Tarir before Mordrem breach its sanctum.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public Tarir() {
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
