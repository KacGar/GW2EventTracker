package com.et4.content.eventDetails.eodEvents;

import com.et4.content.Event;

public class JadeMaw extends Event {

    private final String eventName = "Void-corrupted Jade Maw";
    private final String waypoint = "[&BKIMAAA=]";
    private final String zone = "Dragon's End";
    private final String area = "Cantha";
    private final String description = "Defeat the Void-corrupted Jade Maw is a group event that occurs in the Flooded Basin. " +
            "Summoned minions are killed to generate crystals which are then used to damage the Void-Corrupted Jade Maw.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 5;

    public JadeMaw() {
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
