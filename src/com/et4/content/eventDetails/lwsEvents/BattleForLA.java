package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class BattleForLA extends Event {

    private final String eventName = "The Battle For Lion's Arch";
    private final String waypoint = "[&BAkMAAA=]";
    private final String zone = "Eye of the North";
    private final String area = "Shiverpeak Mountains";
    private final String description = "The Battle For Lion's Arch is an instanced zone in Kryta. It represents the destroyed and hostile captured Lion's Arch " +
            "during the The Battle for Lion's Arch story step in Living World Season 1, and it's based on the zone Lion's Arch (Enemy Controlled) from the original " +
            "Season 1 releases. Although this instance is used for a story step, it is a Public Instance and can also be entered while not on the related story step.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 30;

    public BattleForLA() {
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
