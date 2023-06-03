package com.et4.content;

import com.et4.content.eventDetails.coreEvents.*;
import com.et4.content.eventDetails.eodEvents.*;
import com.et4.content.eventDetails.hotEvents.Chak;
import com.et4.content.eventDetails.hotEvents.Mordremoth;
import com.et4.content.eventDetails.hotEvents.NightBosses;
import com.et4.content.eventDetails.hotEvents.Tarir;
import com.et4.content.eventDetails.lwsEvents.*;
import com.et4.content.eventDetails.pofEvents.*;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Arrays;

/**
 * Blueprint for every event that extends this class and holds all data for a specific event and uses those data
 * in its public methods. Child classes should set all fields with a proper values.
 */
public class Event{

    private String eventName;
    private String waypoint;
    private String zone;
    private String area;
    private String description;
    private String startsAt;
    private int[] scheduleHours;
    private int[] localSchedule;
    private int offsetMins;

    /**
     * Default constructor with no parameter. It is assumed that child classes will set all values.
     */
    protected Event(){}

    // setters
    protected void setEventName(String eventName) {
        this.eventName = eventName;
    }
    protected void setWaypoint(String waypoint) {this.waypoint = waypoint;}
    protected void setZone(String zone) {this.zone = zone;}
    protected void setArea(String area) {this.area = area;}
    protected void setDescription(String description) {this.description = description;}
    protected void setScheduleHours(int[] scheduleHours) {this.scheduleHours = scheduleHours;}
    protected void setLocalSchedule(int[] localSchedule) {this.localSchedule = localSchedule;}
    protected void setOffsetMins(int offsetMins) {this.offsetMins = offsetMins;}
    private void setStartsAt(String startsAt) {this.startsAt = startsAt;}
    // getters
    public String getEventName() {return eventName;}
    public String getWaypoint() {return waypoint;}
    public String getZone() {return zone;}
    public String getArea() {return area;}
    public String getDescription() {return description;}
    public int[] getScheduleHours() {return scheduleHours;}
    public int[] getLocalSchedule() {return localSchedule;}
    public String getStartsAt() {return startsAt;}

    /**
     * Main method wich calculates time when next event will happen. Handles small caveat with event happening on next day
     * (after midnight) and if next day happens technically on next month by using parametrized object of {@link LocalDateTime}.
     * Returned Duration object is used for displaying time in table. {@link Events}
     * {@see calculateSchedule()} method for localized schedule.
     * @return Duration object which holds duration between current user time to next localized schedule for an event.
     */
    public Duration getTime() {
        int currHour = ZonedDateTime.now().getHour();
        int nextEvent = localSchedule[0];

        if (offsetMins == 0){
            // search when next event will occur
            // set value and break loop for less work
            //in case where event happens right after midnight and its late (current hour) - nextevent value isnt changed from init
            for (int i = 0; i < scheduleHours.length; i++){
                if (localSchedule[i] > currHour){
                    nextEvent = localSchedule[i];
                    break;
                }
            }
        } else {
            // search when next event will occur
            // check specific conditions because of offset minute
            // set value and break loop
            for (int i = 0; i < localSchedule.length; i++){
                // condition where hour schedule match with current hour but current minutes are less then offset - meaning right before event
                if (localSchedule[i] == currHour && ZonedDateTime.now().getMinute() < offsetMins){
                    nextEvent = localSchedule[i];
                    break;
                }
                // condition where hour schedule match with current hour but current minutes are higher than offset - meaning we're right after event
                if (localSchedule[i] == currHour && ZonedDateTime.now().getMinute() > offsetMins){
                    // safe check to don't go out of bounds
                    if (i+1 == localSchedule.length){
                        nextEvent = localSchedule[0];
                        break;
                    } else {
                        nextEvent = localSchedule[i + 1];
                        break;
                    }
                }
                // assign next hour schedule when event happens if earlier conditions didnt matched
                if (localSchedule[i] > currHour){
                    nextEvent = localSchedule[i];
                    break;
                }
                // if no conditions matched then user is right before midnight and next schedule is on the next day
                if (i+1 == localSchedule.length){
                    nextEvent = localSchedule[0];
                    break;
                }
            }
        }
        //set text with value of schedule when event starts for user to display, so he can glance at what time event start, not only time left.
        String mins = "";
        String hours = "";
        if (offsetMins == 0) mins = "00";
        else mins = String.valueOf(offsetMins);
        if (nextEvent == 0) hours = "00";
        else if (nextEvent < 10) hours = "0" + nextEvent;
        else hours = String.valueOf(nextEvent);
        String s = hours + ":" + mins;
        setStartsAt(s);

        // works only with events having offset that happen on the same day
        if (nextEvent == currHour){
            LocalTime end = LocalTime.of(nextEvent, offsetMins);
            LocalTime start = LocalTime.now();
            return Duration.between(start,end);
        }
        // works only with events having offset but next event is on the next day
        if (nextEvent == localSchedule[0]){
            // this should cover us with last days of the month/yeat etc
            LocalDateTime nextDay = LocalDateTime.now().plusDays(1);
            LocalDateTime end = LocalDateTime.of(
                    nextDay.getYear(),
                    nextDay.getMonth(),
                    nextDay.getDayOfMonth(),
                    localSchedule[0],
                    offsetMins,
                    0
            );
            return Duration.between(LocalDateTime.now(), end);
        }
        // works for every other case with zero offset (meaning full hours)
        LocalTime end = LocalTime.of(nextEvent, offsetMins);
        LocalTime start = LocalTime.now();
        return Duration.between(start, end);
    }

    /**
     * Calculates local to user schedule for a specific event based by its (event) schedule with UTC-+0.
     * @return Array object of int type with localized schedule (hours)
     */
    protected final int[] calculateSchedule(){
        ZonedDateTime zdt = ZonedDateTime.now();
        int utcZoneOffset = (zdt.getOffset().get(ChronoField.OFFSET_SECONDS) / 60) / 60;
        int[] localSchedule = new int[scheduleHours.length];
        for (int i = 0; i < scheduleHours.length; i++){
            int newHour;
            if (scheduleHours[i] + utcZoneOffset > 23) newHour = scheduleHours[i] + utcZoneOffset - 24;
            else newHour = scheduleHours[i] + utcZoneOffset;
            localSchedule[i] = newHour;
        }
        Arrays.sort(localSchedule);
        return localSchedule;
    }

    /**
     * Method which returns new instance of specified string. String parameter has to be exact as event name.
     * @param name Event name type of String
     * @return {@link Event} object for specified event.
     */
    public static Event getInstanceOf(String name){
        switch (name){
            case "Admiral Taidha" -> {return new AdmiralTaidha();}
            case "Svanir Shaman" -> {return new SvanirShaman();}
            case "Megadestroyer" -> {return new Megadestroyer();}
            case "Fire Elemental" -> {return new FireElemental();}
            case "The Shatterer" -> {return new Shatterer();}
            case "Great Jungle Wurm" -> {return new GreatJungleWurm();}
            case "Modnir Ulgoth" -> {return new ModnirUlgoth();}
            case "Shadow Behemoth" -> {return new Shadowbehemoth();}
            case "Golem Mark II" -> {return new GolemMark2();}
            case "Claw of Jormag" -> {return new ClawOfJormag();}
            case "Tequatl the Sunless" -> {return new Tequatl();}
            case "Karka Queen" -> {return new KarkaQueen();}
            case "Triple Trouble" -> {return new TripleTrouble();}
            case "LeyLine Anomaly" -> {return new LeyLineAnomaly();}
            case "Night Bosses" -> {return new NightBosses();}
            case "Chak Gerenth" -> {return new Chak();}
            case "Octovine" -> {return new Tarir();}
            case "Mordremoth" -> {return new Mordremoth();}
            case "Buried Treasure" -> {return new BuriedTreasure();}
            case "Doppelganger" -> {return new Doppelganger();}
            case "Forged with Fire" -> {return new ForgedWithFire();}
            case "Junundu Rising" -> {return new JununduRising();}
            case "Maws Of Torment" -> {return new MawsOfTorment();}
            case "Piniata" -> {return new Piniata();}
            case "Serpents' Ire" -> {return new SerpentsIre();}
            case "Aetherblade Assault" -> {return new AetherbladeAssault();}
            case "Aspenwood" -> {return new Aspenwood();}
            case "The Gang War of Echovald" -> {return new GangWar();}
            case "Void-corrupted Jade Maw" -> {return new JadeMaw();}
            case "Kaineng Blackout" -> {return new KainengBlackout();}
            case "Soo-Won" -> {return new SooWon();}
            case "Awakened Invasion" -> {return new AwakenedInvasion();}
            case "The Battle For Lion's Arch" -> {return new BattleForLA();}
            case "Death-Branded Shatterer" -> {return new DBS();}
            case "Doomlore Shrine" -> {return new DoomloreShrine();}
            case "Dragonstorm" -> {return new Dragonstorm();}
            case "Drakkar" -> {return new Drakkar();}
            case "Effigy" -> {return new Effigy();}
            case "Metal Concert" -> {return new MetalConcert();}
            case "New Loamhurst" -> {return new NewLoamhurst();}
            case "Noran's Homestead" -> {return new NoransHomestead();}
            case "The Oil Floes" -> {return new OilFloes();}
            case "The Ooze Pit Trials" -> {return new OozePits();}
            case "Paladawan" -> {return new Paladawan();}
            case "Saidra's Haven" -> {return new SaidraHaven();}
            case "Sandstorm" -> {return new Sandstorm();}
            case "Defeat the Scarlet Briar" -> {return new Scarlet();}
            case "Storms Of Winter" -> {return new StormsOfWinter();}
            case "Thunderhead Keep" -> {return new ThunderheadKeep();}
            case "The Tower of Nightmares" -> {return new TowerOfNightmare();}
            case "Twisted Marionette" -> {return new TwistedMarionette();}
            default -> {return new Event();}
        }
    }

}