package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class Aspenwood extends Event {

    private final String eventName = "Aspenwood";
    private final String waypoint = "[&BPkMAAA=]";
    private final String zone = "The Echovald Wilds";
    private final String area = "Aspenwood Gulch";
    private final String description = "Use the siege turtles to destroy the shield generators as you fight through the fort is a level 80 chained event in the Echovald Wilds." +
            " The event occurs at the start of the Canthan night. Players must destroy all three pairs of generators within the 15-minute time limit to complete the event.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 40;

    public Aspenwood() {
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
