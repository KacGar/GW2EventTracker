package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class GangWar extends Event {

    private final String eventName = "The Gang War of Echovald";
    private final String waypoint = "[&BBkNAAA=]";
    private final String zone = "The Echovald Wilds";
    private final String area = "Cantha";
    private final String description = "The Gang War of Echovald is the ongoing meta event that occurs in The Echovald Wilds. " +
            "It is constantly visible from the entire map, though most of the time Echovald is in a state of peace with no significant hostility between " +
            "the two rival gangs of Echovald; the Speakers and the Jade Brotherhood.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 30;

    public GangWar() {
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
