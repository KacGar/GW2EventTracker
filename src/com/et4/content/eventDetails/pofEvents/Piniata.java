package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class Piniata extends Event {

    private final String eventName = "Piniata";
    private final String waypoint = "[&BLsKAAA=]";
    private final String zone = "Crystal Oasis";
    private final String area = "Free City of Amnoon";
    private final String description = "Casino Blitz is a meta event that takes place around the Free City of Amnoon in Crystal Oasis.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 20;

    public Piniata() {
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
