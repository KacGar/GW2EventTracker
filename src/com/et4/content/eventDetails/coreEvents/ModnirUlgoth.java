package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class ModnirUlgoth extends Event {

    private final String eventName = "Modnir Ulgoth";
    private final String waypoint = "[&BLAAAAA=]";
    private final String zone = "Harathi Hinterlands";
    private final String area = "Modniir Gorge";
    private final String description = "Defeat Ulgoth the Modniir and his minions is a level 43 group event in Modniir Gorge in Harathi Hinterlands.";

    private static final int[] scheduleHours = {1,4,7,10,13,16,19,22};
    private final int offsetMins = 30;

    public ModnirUlgoth() {
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
