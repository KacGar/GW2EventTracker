package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class GreatJungleWurm extends Event {

    private final String eventName = "Great Jungle Wurm";
    private final String waypoint = "[&BEEFAAA=]";
    private final String zone = "Caledon Forest";
    private final String area = "Wychmire Swamp";
    private final String description = "Defeat the great jungle wurm is a level 15 group event that occurs in Wychmire Swamp in Caledon Forest. " +
            "It is the last part of The Battle for Wychmire Swamp, and a Swamp Chest will spawn upon completion.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 15;

    public GreatJungleWurm() {
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
