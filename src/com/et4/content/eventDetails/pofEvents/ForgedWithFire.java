package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class ForgedWithFire extends Event {

    private final String eventName = "Forged with Fire";
    private final String waypoint = "[&BO0KAAA=]";
    private final String zone = "Domain of Vabbi";
    private final String area = "The Foundry";
    private final String description = "Forged with Fire is a meta event that takes place in The Foundry on the western edge of Domain of Vabbi. " +
            "Players must escort an Awakened Commander to take down Priests of Balthazar powering cannonades. After defeating the cannonades, " +
            "you must kill a Champion Forged Officer, who then summons Balthazar's Legendary Warhounds, Temar and Tegon.";

    private static final int[] scheduleHours = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    private final int offsetMins = 0;

    public ForgedWithFire() {
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
