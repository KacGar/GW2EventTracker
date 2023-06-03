package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

public class FireElemental extends Event {

    private final String eventName = "Fire Elemental";
    private final String waypoint = "[&BEcAAAA=]";
    private final String zone = "Metrica Province";
    private final String area = "Thaumanova Reactor";
    private final String description = "Destroy the fire elemental created from chaotic energy fusing with the C.L.E.A.N. " +
            "5000's energy core is a level 15 group event that occurs in Thaumanova Reactor in Metrica Province.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 45;

    public FireElemental() {
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
