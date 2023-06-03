package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class AetherbladeAssault extends Event {

    private final String eventName = "Aetherblade Assault";
    private final String waypoint = "[&BAIIAAA=]";
    private final String zone = "Seitung Province";
    private final String area = "Haiju Lagoon";
    private final String description = "Aetherblade Assault is a level 80 meta event that occurs in Seitung Province. " +
            "Villages on the northern shore are being pillaged by the Aetherblades and the allied forces are attempting to stop them.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 30;

    public AetherbladeAssault() {
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
