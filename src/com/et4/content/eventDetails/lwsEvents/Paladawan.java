package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Paladawan extends Event {

    private final String eventName = "Paladawan";
    private final String waypoint = "[&BAkLAAA=]";
    private final String zone = "Domain of Istan";
    private final String area = "Crystal Desert";
    private final String description = "Palawadan, Jewel of Istan is a meta event that takes place in Domain of Istan every 120 minutes. " +
            "The event is 30 minutes long, and starts just after dusk (that is, fifteen minutes before the daily reset and every two hours thereafter).";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 45;

    public Paladawan() {
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
