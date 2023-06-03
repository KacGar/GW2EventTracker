package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class ClawOfJormag extends Event {

    private final String eventName = "Claw of Jormag";
    private final String waypoint = "[&BHoCAAA=]";
    private final String zone = "Frostgorge Sound";
    private final String area = "Frostwalk Tundra";
    private final String description = "Defeat the Claw of Jormag is a level 80 event in and around Frostwalk Tundra in Frostgorge Sound. " +
            "It is the last event in Breaking the Claw of Jormag where players face down the Claw of Jormag. " +
            "Upon the dragon's defeat, the Frost Chest will spawn for players.";

    private static final int[] scheduleHours = {2,5,8,11,14,17,20,23};
    private final int offsetMins = 30;

    public ClawOfJormag() {
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
