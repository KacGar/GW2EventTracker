package com.et4.content.eventDetails.pofEvents;

import com.et4.content.Event;

public class Doppelganger extends Event {

    private final String eventName = "Doppelganger";
    private final String waypoint = "[&BFMKAAA=]";
    private final String zone = "Elon Riverlands";
    private final String area = "Crystal Desert";
    private final String description = "The Path to Ascension is a meta event that takes place in Elon Riverlands and is needed to unlock access to the Hall of Ascension in Augury Rock.";

    private static final int[] scheduleHours = {1,3,5,7,9,11,13,15,17,19,21,23};
    private final int offsetMins = 30;

    public Doppelganger() {
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
