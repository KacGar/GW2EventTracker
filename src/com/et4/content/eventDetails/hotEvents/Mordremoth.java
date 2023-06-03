package com.et4.content.eventDetails.hotEvents;

import com.et4.content.Event;

public class Mordremoth extends Event {

    private final String eventName = "Mordremoth";
    private final String waypoint = "[&BBAIAAA=]";
    private final String zone = "Dragon's Stand";
    private final String area = "Heart of Maguuma";
    private final String description = "Advancing on the Blighting Towers is a map meta event that occurs in Dragon's Stand." +
            " The Pact has finally entered Mordremoth's domain, and are assaulting the dragon's defenses in order to reach and finally deal with the jungle dragon itself.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 30;

    public Mordremoth() {
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
