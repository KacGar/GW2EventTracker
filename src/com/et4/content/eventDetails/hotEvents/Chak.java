package com.et4.content.eventDetails.hotEvents;

import com.et4.content.Event;

public class Chak extends Event {

    private final String eventName = "Chak Gerenth";
    private final String waypoint = "[&BPUHAAA=]";
    private final String zone = "Tangled Depths";
    private final String area = "Heart of Maguuma";
    private final String description = "King of the Jungle is the map meta event in Tangled Depths. All four outposts have been established and now the Order of Whispers " +
            "is trying to fire a cannon into Dragon's Stand to bring the fight to Mordremoth, but they must protect the cannons from the most powerful kind of Chak, " +
            "the Legendary Chak Gerent, to do so. The event to spawn the Legendary Chak Gerent happens every 20 minutes past the hour, at a 2 hour interval rate." +
            " Once the 20 minute timer reaches its end, two timers will pop up once more, both having 5 minutes each; giving the people a heads-up that the Gerent is about to spawn.\n" +
            "\n" +
            "Players must contest four lanes: Rata Novus Lane, Nuhoch Lane, Ogre Lane, and SCAR Lane. The goal in each is to use the lane's special mechanics to spawn " +
            "the Chak Gerent and then to kill it. Failure to do so will cause the Chak Gerent to burrow straight ahead to the cannon and destroy it in one blow, making the meta event fail.";

    private static final int[] scheduleHours = {0,2,4,6,8,10,12,14,16,18,20,22};
    private final int offsetMins = 30;

    public Chak() {
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
