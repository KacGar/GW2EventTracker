package com.et4.content.eventDetails.hotEvents;

import com.et4.content.Event;

public class NightBosses extends Event {

    private final String eventName = "Night Bosses";
    private final String waypoint = "[&BAgIAAA=]";
    private final String zone = "Verdant Brink";
    private final String area = "Heart of Maguuma";
    private final String description = "Night and the Enemy is a map meta event that occurs in Verdant Brink during the night " +
            "cycle. It involves securing the various Pact rally points and upgrading them, while fending off Mordrem " +
            "assaults until morning as well as defeating various bosses that appear at night.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 10;

    public NightBosses() {
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
