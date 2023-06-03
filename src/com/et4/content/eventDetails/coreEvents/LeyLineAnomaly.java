package com.et4.content.eventDetails.coreEvents;

import com.et4.content.Event;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class LeyLineAnomaly extends Event {

    private final String eventName = "Leyline Anomaly";
    private final String description = "Defeat the Ley-Line Anomaly to disperse its destructive energy before it overloads is a level 26, 54, " +
            "or 56 map-wide event that occurs respectively in Gendarran Fields, Iron Marches, or Timberline Falls. " +
            "These are areas with overflowing ley line energy, whereas other zones have smaller leaks.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 20;

    public LeyLineAnomaly() {
        super();
        super.setEventName(this.eventName);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setLocalSchedule(super.calculateSchedule());
        super.setOffsetMins(offsetMins);
        setMapInfo();
    }

    private void setMapInfo(){
        ZonedDateTime zdt = ZonedDateTime.now();
        int currHour = zdt.getHour();
        int utcZoneOffset = (zdt.getOffset().get(ChronoField.OFFSET_SECONDS) / 60) / 60;
        int[] unsortedSchedule = new int[scheduleHours.length];
        for (int i = 0; i < scheduleHours.length; i++){
            int newHour;
            if (scheduleHours[i] + utcZoneOffset > 23) newHour = scheduleHours[i] + utcZoneOffset - 23;
            else newHour = scheduleHours[i] + utcZoneOffset;
            unsortedSchedule[i] = newHour;
        }
        int index = 0;
        if (zdt.getMinute() < 20){
            for (int e : unsortedSchedule){
                if (e >= currHour) index++;
            }
        } else {
            for (int e : unsortedSchedule){
                if (currHour <= e) index++;
            }
        }
        switch (index%3){
            case 0 -> {
                super.setWaypoint("[&BOcBAAA=]");
                super.setZone("Iron Marches");
                super.setArea("Monger's Sink");
            }
            case 1 -> {
                super.setWaypoint("[&BOQAAAA=]");
                super.setZone("Gendarran Fields");
                super.setArea("Provern Shore");
            }
            case 2 -> {
                super.setWaypoint("[&BEwCAAA=]");
                super.setZone("Timberline Falls");
                super.setArea("Fisher's Eye Bridges");
            }
        }
    }
}
