package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class Tequatl extends Event {

    private final String eventName = "Tequatl the Sunless";
    private final String waypoint = "[&BNABAAA=]";
    private final String zone = "Sparkfly Fen";
    private final String area = "Splintered Coast";
    private final String description = "Defeat Tequatl the Sunless is a level 65 group event that occurs on the Splintered Coast in Sparkfly Fen. " +
            "The event begins with Tequatl the Sunless flying out of the water, eventually landing in front of the player " +
            "and beginning combat. Though considered one of the smaller dragons, Tequatl is not alone and the fight occurs " +
            "with dangerous minions summoned to attack the players as well. Players themselves have access to numerous " +
            "Hylek Turrets and are backed by the formidable Vigil Megalaser.";

    private static final int[] scheduleHours = {0,3,7,11,16,19};
    private final int offsetMins = 0;

    public Tequatl() {
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
        int hour1 = scheduleHours[2] + utcZoneOffset;
        int hour2 = scheduleHours[3] + utcZoneOffset;
        int currHour = zdt.getHour();
        if (currHour > hour1 && currHour < hour2) {super.setOffsetMins(30);}
        else super.setOffsetMins(0);
    }
}
