package com.et4.content.eventDetails.lwsEvents;

import com.et4.content.Event;
import java.time.ZonedDateTime;

public class AwakenedInvasion extends Event {

    private final String eventName = "Awakened Invasion";
    private final String description = "Defeat the invading Awakened is a group event that occurs every hour at xx:30 in one of seven predefined zones across Tyria.";
    private final String[][] data = {
                                        {"Southsun Cove","[&BNUGAAA=]"},
                                        {"Queensdale","[&BO8AAAA=]"},
                                        {"Gendarran Fields","[&BOQAAAA=]"},
                                        {"Caledon Forest","[&BDoBAAA=]"},
                                        {"Plains of Ashford","[&BIABAAA=]"},
                                        {"Metrica Province","[&BEcAAAA=]"},
                                        {"Wayfarer Foothills","[&BH0BAAA=]"},
                                    };

    private static final int[] scheduleHours = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    private final int offsetMins = 30;

    public AwakenedInvasion() {
        super();
        super.setEventName(this.eventName);
        int index = ZonedDateTime.now().getDayOfWeek().getValue() - 1 ;
        setData(sortZonesAndWp(), index);
        super.setDescription(this.description);
        super.setScheduleHours(scheduleHours);
        super.setLocalSchedule(super.calculateSchedule());
        super.setOffsetMins(offsetMins);
    }

    private String[][] sortZonesAndWp(){
        int currHour = ZonedDateTime.now().getHour();
        if (currHour - 2 < 0) currHour = 24 - currHour;
        else currHour-=2;
        currHour = currHour % 7;
        String[][] shuffled = new String[7][2];
        if (currHour == 0){
            super.setZone(data[0][0]);
            super.setArea(data[0][0]);
            super.setWaypoint(data[0][1]);
        } else {
            shuffled = shuffle(currHour);
        }
        return shuffled;
    }

    private String[][] shuffle(int num){
        String[][] temp = new String[7][2];
        int index = 0;
        // 0,2,4,6,1,3,5
        switch (num){
            case 0 -> {}
            case 1 -> index = 2;
            case 2 -> index = 4;
            case 3 -> index = 6;
            case 4-> index = 1;
            case 5-> index = 3;
            case 6-> index = 5;
        }
        for (int i = 0; i < data.length; i++){
            temp[index][0] = data[i][0];
            temp[index][1] = data[i][1];
            index++;
            if (index == 7) index = 0;
        }
        return temp;
    }

    private void setData(String[][] data, int index){
        super.setZone(data[index][0]);
        super.setArea(data[index][0]);
        super.setWaypoint(data[index][1]);
    }
}
