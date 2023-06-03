package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;

public class StormsOfWinter extends Event {

    private final String eventName = "Storms Of Winter";
    private final String waypoint = "[&BCcMAAA=]";
    private final String zone = "Bjora Marches";
    private final String area = "Frozen Pass";
    private final String description = "Storms of Winter is a level 80 meta event that occurs in Frozen Pass, in Bjora Marches. " +
            "The Fraenir of Jormag, using magic stolen from Raven, has summoned a massive blizzard around Jora's Keep, and an army of Sons of Svanir, Icebrood, " +
            "Fallen, and Aberrant, are moving in. Keep Havroun Weibe safe while he gathers enough energy to counter the storm and call on Raven to protect the keep against those" +
            " that steal his power.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 45;

    public StormsOfWinter() {
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
