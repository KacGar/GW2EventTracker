package com.et4.controls;

import com.et4.Et4GUI;
import com.et4.content.Event;
import com.et4.content.Events;
import com.et4.controls.menuController.MenuHandlers;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Controller class of GUI applcation that controls simple interactions, like starting countdown, handling checkboxes
 * or interaction with user and table. User upon clicking cell with waypoint on it fires method which copies text to user clipboard.
 */
public class Controller implements ActionListener, ItemListener, ListSelectionListener{

    protected Et4GUI appGUI;
    private JTable table;

    /**
     * Static ArrayList of type String used to save currently displayed events. Used whenever user decides to save those events in a file.
     */
    public static ArrayList<String> chosenEvents = new ArrayList<>();

    /**
     * Static ArraList of type JTable that is assigned whenever user interacts with currently displayed table. Used to handle copying waypoint.
     */
    public static ArrayList<JTable> tables = new ArrayList<>();



    /**
     * Constructor of Controller class with one parameter of GUI object.
     * @param appGUI GUI object of Et4GUI type (extends JFrame)
     */
    public Controller(Et4GUI appGUI) {
        this.appGUI = appGUI;
    }

    /**
     * Constructor with one parameter that assings JTable for later use, like countdown or handling list selection action
     * @param aTable JTable object that is passed when ListSelection event is fired.
     */
    public Controller(JTable aTable){
        this.table = aTable;
    }

    /**
     * Public static method which creates default panel with every event displayed.
     * @param appGUI GUI object to access content panel
     * @return JScrollPane object with content panel as its view
     */
    public static JScrollPane getDefaultPanel(Et4GUI appGUI){
        new Events(appGUI).allEvents();
        return new JScrollPane(appGUI.contentPanel);
    }

    /**
     * Method upon which panel with favorite events is created. Searching and reading is outside of user interaction unless I/O error occurs in internal method. \n
     * Method is called whenever user chose to load his events upon launching application.
     * @param appGUI GUI object of type Et4GUI (extends JFrame)
     */
    public static void getFavPanel(Et4GUI appGUI){
       new MenuHandlers(appGUI).quickLoadFavorites();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //btn action performed after choosing specific events
        if (e.getActionCommand().equalsIgnoreCase("showChosen")){
            String label = appGUI.langBundle.getString("selectedEvents");
            new Events(appGUI).showSelected(chosenEvents, label);
        }

        // activation of countdown method which is activated through timer object in GUI object
        if (e.getActionCommand().equalsIgnoreCase("countdown")){
            countdownStart(tables);
        }

        // after user clicked cell with waypoint, text in cell was modified, after delay original text with waypoint is restored in cell
        // original text is contained in action command
        if (e.getActionCommand().contains("waypoint")){
            int start = e.getActionCommand().indexOf("[");
            int end = e.getActionCommand().lastIndexOf("]") + 1;
            String s = e.getActionCommand().substring(start, end);
            start = 0;
            end = e.getActionCommand().lastIndexOf(":");
            int row = Integer.parseInt(
                    e.getActionCommand().substring(start,end));
            table.getModel().setValueAt(s,row,4);
        }
    }

    /**
     * Handler of {@link JCheckBox} items, where adds/removes values (Box text is a proper event name used later as a value for creating objects)
     * to/from static arraylist in {@link Controller} class.
     * @param e {@link ItemEvent} object which implements ItemListener interface.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox box = (JCheckBox) e.getSource();
        if (box.isSelected()){
            chosenEvents.add(box.getText());
        } else {
            chosenEvents.remove(box.getText());
        }

    }

    /**
     * Method which handles user selection on displayed table. \n
     * If user click on column with waypoints then method checks which row was selected and copies text from cell
     * (which is waypoint code) to user system clipboard. After that fires timer with 1,5sec delay to restore original text.
     * @param e {@link ListSelectionEvent} object which implements ListSelectionListener interface
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            // if user chose proper column, otherwise do nothing
            if (table.getSelectedColumn() == 4){
                //get clicked cell
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                String wpCodeText = table.getModel().getValueAt(row,column).toString();

                // copy waypoint text into clipboard
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(wpCodeText);
                clipboard.setContents(strSel, null);

                // inform user that waypoint was copied
                table.getModel().setValueAt("Waypoint copied",row, column);
                // after 2 sec delay, set again proper waypoint text, delegated to listener, info passed through action command
                Timer timer = new Timer(1500, this);
                timer.setActionCommand(row + ":waypoint" + wpCodeText);
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    /**
     * Main method handling countdown timer for every event displayed in table or multiple tables.
     * @param tables ArrayList with JTable objects that are currently displayed. createTable method in {@link Events} adds created table in said arraylist.
     */
    public static void countdownStart(ArrayList<JTable> tables){
        for (JTable jTable : tables){
            // go through every table
            int i = 0;
            while (i < jTable.getRowCount()){
                // do work for every row

                //take value from cell
                String  s = jTable.getModel().getValueAt(i,1).toString();
                int firstIndex = s.indexOf(":");
                int secondIndex = s.lastIndexOf(":");
                // parsing as int and lowering by 1 sec
                int hours = Integer.parseInt(s.substring(0,firstIndex));
                int minutes = Integer.parseInt(s.substring(firstIndex + 1, secondIndex));
                int seconds = Integer.parseInt(s.substring(secondIndex + 1));
                // if seconds = 0 then take -1 minute and assing 59secs, if secs and mins are zero, take -1 hour and assing 59 for min and secs
                if (seconds > 0){
                    seconds--;
                } else {
                    if ( minutes > 0){
                        minutes--;
                        seconds = 59;
                    } else {
                        if (hours > 0){
                            minutes = 59;
                            seconds = 59;
                        }
                    }
                }
                // if countdown goes to zero, new event object is created and time values are set
                if (hours == 0 && minutes == 0 && seconds == 0 ){
                    // gets event name and use that to get new instance
                    String eventName = jTable.getModel().getValueAt(i,0).toString();
                    Event event = Event.getInstanceOf(eventName);
                    String newTime = "";
                    // format time
                    if (event.getTime().toHoursPart() < 10) newTime = "0" + newTime;
                    if (event.getTime().toMinutesPart() < 10) newTime = newTime + ":0" + event.getTime().toMinutesPart();
                    else newTime = newTime + ":" + event.getTime().toMinutesPart();
                    if (event.getTime().toSecondsPart() < 10) newTime = newTime + ":0" + event.getTime().toSecondsPart();
                    else newTime = newTime + ":" + event.getTime().toSecondsPart();
                    //set values in TIME cell and STARTS AT cell
                    jTable.getModel().setValueAt(newTime,i,1);
                    jTable.getModel().setValueAt(event.getStartsAt(),i,2);
                } else {
                    // otherwise lower one sec and set new value in cell
                    String loweredValue = "";
                    if (hours < 10) loweredValue = "0" + hours;
                    else loweredValue = String.valueOf(hours);
                    if (minutes < 10) loweredValue = loweredValue + ":0" + minutes;
                    else loweredValue = loweredValue + ":" + minutes;
                    if (seconds < 10) loweredValue = loweredValue + ":0" + seconds;
                    else loweredValue = loweredValue + ":" + seconds;
                    jTable.getModel().setValueAt(loweredValue, i, 1);
                }
                //next row
                i++;
            }
        //end of tables loop
        }
    }


}

