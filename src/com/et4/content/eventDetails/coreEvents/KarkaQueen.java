package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class KarkaQueen extends Event {

    private final String eventName = "Karka Queen";
    private final String waypoint = "[&BNUGAAA=]";
    private final String zone = "Southsun Cove";
    private final String area = "Driftglass Springs";
    private final String description = "Defeat the Karka Queen threatening the settlements is a level-80 group event that can occur " +
            "in Driftglass Springs or Southsun Shoals. This event will not start until all four settlements have been reclaimed " +
            "from the karka via the Island Control meta event.";

    private static final int[] scheduleHours = {2,6,10,15,18,23};

    public KarkaQueen() {
        super();
        super.setEventName(this.eventName);
        super.setWaypoint(this.waypoint);
        super.setZone(this.zone);
        super.setArea(this.area);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setLocalSchedule(super.calculateSchedule());
        setupOffset();
    }

    private void setupOffset(){
        ZonedDateTime zdt = ZonedDateTime.now();
        int utcZoneOffset = (zdt.getOffset().get(ChronoField.OFFSET_SECONDS) / 60) / 60;
        int hour1 = scheduleHours[1] + utcZoneOffset;
        int hour2 = scheduleHours[2] + utcZoneOffset;
        int currHour = zdt.getHour();
        if (currHour > hour1 && currHour < hour2) {super.setOffsetMins(30);}
        else super.setOffsetMins(0);
    }
}
