package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class MawsOfTorment extends Event {

    private final String eventName = "Maws Of Torment";
    private final String waypoint = "[&BKMKAAA=]";
    private final String zone = "The Desolation";
    private final String area = "Crystal Desert";
    private final String description = "Maws of Torment is a meta event in the Desolation.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 0;

    public MawsOfTorment() {
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
