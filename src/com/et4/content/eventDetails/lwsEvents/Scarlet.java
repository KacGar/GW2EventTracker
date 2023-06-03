package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class Scarlet extends Event {

    private final String eventName = "Defeat the Scarlet Briar";
    private final String waypoint = "[&BOQAAAA=]";
    private final String zone = "Gendarran Fields";
    private final String area = "Kryta";
    private final String description = "Defeat the invading minions of Scarlet Briar is a dynamic event that can occur throughout Gendarran Fields every odd hour UTC. " +
            "There are three waves of invading minions. First wave has three events, second wave has four events and last wave has five events. Events spawn randomly " +
            "among a set of predefined locations. ";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public Scarlet() {
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
