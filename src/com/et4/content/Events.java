package com.et4.content;

import com.et4.Et4GUI;
import com.et4.controls.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that holds info what events are in game and has methods that are used for creating content for contentPanel.
 * \n To add new event simply put String value in proper region. If new region will appear then new array has to be created
 * and its proper get methods in a class.
 * Every method with parameter expects proper parameter, null parameters are not handled.
 */
public class Events {

    private final Et4GUI appGUI;
    private Object[][] data;
    private final GridBagConstraints gbc = new GridBagConstraints();

    private final String[] columns = {"EVENT NAME","TIME","MAP","AREA","WAYPOINT"};
    private final String[] coreEvents = {"Admiral Taidha","Svanir Shaman","Megadestroyer","Fire Elemental","The Shatterer",
                                        "Great Jungle Wurm","Modnir Ulgoth","Shadow Behemoth","Golem Mark II","Claw of Jormag",
                                        "Tequatl the Sunless","Karka Queen","Triple Trouble","LeyLine Anomaly"};

    private final String[] hotEvents = {"Night Bosses","Chak Gerenth","Octovine","Mordremoth"};

    private final String[] pofEvents = {"Piniata","Buried Treasure","Doppelganger","Junundu Rising","Maws Of Torment","Serpents' Ire","Forged with Fire"};

    private final String[] eodEvents = {"Aetherblade Assault","Kaineng Blackout","The Gang War of Echovald","Aspenwood","Soo-Won","Void-corrupted Jade Maw"};

    private final String[] lwsEvents = {"Twisted Marionette","The Battle For Lion's Arch","The Tower of Nightmares","Defeat the Scarlet Briar",
                                        "Sandstorm",
                                        "New Loamhurst","Noran's Homestead", "Saidra's Haven",
                                        "Awakened Invasion","Paladawan","Death-Branded Shatterer","The Oil Floes","Thunderhead Keep",
                                        "Effigy","Doomlore Shrine","The Ooze Pit Trials","Metal Concert","Storms Of Winter","Drakkar","Dragonstorm"};

    /**
     * Constructor taking application GUI as its parameter and initializes column names.
     * @param appGUI GUI of application to have access to contentpanel
     */
    public Events(Et4GUI appGUI){
        this.appGUI = appGUI;
        columns[0] = appGUI.langBundle.getString("columnEvent");
        columns[1] = appGUI.langBundle.getString("columnTime");
        columns[2] = appGUI.langBundle.getString("columnSchedule");
        columns[3] = appGUI.langBundle.getString("columnMap");
        columns[4] = appGUI.langBundle.getString("columnWaypoint");
    }

    // getters for every string arrays
    public String[] getCore() {return coreEvents;}
    public String[] getHot() {return hotEvents;}
    public String[] getPof() {return pofEvents;}
    public String[] getEod() {return eodEvents;}
    public String[] getLws() {return lwsEvents;}
    public ArrayList<String> getAllEvents() {
        var allEvents = new ArrayList<String>();
        allEvents.addAll(Arrays.asList(coreEvents));
        allEvents.addAll(Arrays.asList(hotEvents));
        allEvents.addAll(Arrays.asList(pofEvents));
        allEvents.addAll(Arrays.asList(eodEvents));
        allEvents.addAll(Arrays.asList(lwsEvents));
        return allEvents;
    }

    // getter for panels with correspond region
    public JPanel coreEvents(){ return getPanelWithTable(createTable(coreEvents));}
    public JPanel hotEvents(){ return getPanelWithTable(createTable(hotEvents));}
    public JPanel pofEvents(){ return getPanelWithTable(createTable(pofEvents));}
    public JPanel eodEvents(){ return getPanelWithTable(createTable(eodEvents));}
    public JPanel lwsEvents(){ return getPanelWithTable(createTable(lwsEvents));}

    public JPanel allEvents(){
        Controller.tables.clear();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JLabel jLabel = new JLabel(appGUI.langBundle.getString("labelCore"));
        setLabelSettings(jLabel);
        this.appGUI.contentPanel.add(jLabel, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(coreEvents(), gbc);

        JLabel jLabel1 = new JLabel(appGUI.langBundle.getString("labelHot"));
        setLabelSettings(jLabel1);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(jLabel1, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(hotEvents(), gbc);

        JLabel jLabel2 = new JLabel(appGUI.langBundle.getString("labelPof"));
        setLabelSettings(jLabel2);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(jLabel2, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(pofEvents(), gbc);

        JLabel jLabel3 = new JLabel(appGUI.langBundle.getString("labelEod"));
        setLabelSettings(jLabel3);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(jLabel3, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(eodEvents(), gbc);

        JLabel jLabel4 = new JLabel(appGUI.langBundle.getString("labelLws"));
        setLabelSettings(jLabel4);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(jLabel4, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(lwsEvents(), gbc);
        return this.appGUI.contentPanel;
    }

    /**
     * Simple delegator for setting similar settings for labels.
     * @param jLabel Text of label to set settings for.
     */
    private static void setLabelSettings(JLabel jLabel){
        jLabel.setFont(jLabel.getFont().deriveFont(20f));
        jLabel.setFocusable(false);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setBorder(BorderFactory.createEmptyBorder(12,5,12,5));
    }

    /**
     * Main method for creating tables with provided String array as parameter with event names values in it.
     * @param array Array of type String that holds event names
     * @return JTable object with information about events
     */
    private JTable createTable(String[] array){
        //array length corresponds to amount of rows that will be displayed
        data = new String[array.length][columns.length];
        for (int i = 0; i < array.length; i++){
            //get instance of specific event and format time
            Event event = Event.getInstanceOf(array[i]);
            String time = String.valueOf(event.getTime().toHoursPart());
            if (event.getTime().toHoursPart() < 10) time = "0" + time;
            if (event.getTime().toMinutesPart() < 10) time = time + ":0" + event.getTime().toMinutesPart();
            else time = time + ":" + event.getTime().toMinutesPart();
            if (event.getTime().toSecondsPart() < 10) time = time + ":0" + event.getTime().toSecondsPart();
            else time = time + ":" + event.getTime().toSecondsPart();
            //put data in proper column
            data[i][0] = event.getEventName();
            data[i][1] = time;
            data[i][2] = event.getStartsAt();
            data[i][3] = event.getZone();
            data[i][4] = event.getWaypoint();
        }
        // overriding model where sells are not editable
        TableModel model = new DefaultTableModel(data, columns){
            public boolean isCellEditable(int row, int column){return false;}
        };

        //init table and set simple settings
        JTable jTable = new JTable(model);
        jTable.setRowSelectionAllowed(true);
        jTable.setColumnSelectionAllowed(true);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable.getColumnCount(); i++){
            jTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        jTable.setShowHorizontalLines(true);
        jTable.setRowHeight(jTable.getRowHeight()+10);
        //pass this table upon user clicking cell to a static field, so multiple tables can be handled with one method
        jTable.getSelectionModel().addListSelectionListener(new Controller(jTable));
        Controller.tables.add(jTable);
        return jTable;
    }

    /**
     * Simply wraps passed table in a {@link JPanel}
     * @param jTable Table to wrap
     * @return new JPanel with passed table.
     */
    private JPanel getPanelWithTable(JTable jTable){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jTable.getTableHeader(), BorderLayout.NORTH);
        jPanel.add(jTable, BorderLayout.CENTER);
        return  jPanel;
    }

    /**
     * Show selected events by user, no additional action needed, content panel is updated internally.
     * @param selected ArrayList of type String with names of events chose by user
     * @param label region label to display above table
     */
    public void showSelected(ArrayList<String> selected, String label) {
        //do work if not empty
        if (!(selected.isEmpty())){
            String[] selectedEvents = new String[selected.size()];
            //table is created from String array, so we quickly take values from list and assign to our array
            // its the only place where we do such a 'conversion', therefore its no use, to have list fields in class where arrays are a bit faster
            for (int i = 0; i < selected.size(); i++){
                selectedEvents[i] = selected.get(i);
            }

            appGUI.contentPanel.removeAll();
            JLabel jLabel = new JLabel(label);
            setLabelSettings(jLabel);

            //first put label and table under it
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            appGUI.contentPanel.add(jLabel, gbc);
            gbc.gridy += 1;

            Controller.tables.clear();
            JTable jTable = createTable(selectedEvents);
            appGUI.contentPanel.add(getPanelWithTable(jTable), gbc);
            appGUI.contentPanel.updateUI();
        } else {
            //if user didn't choose anything inform him to actually chose something
            String msg = appGUI.langBundle.getString("pleaseChoose");
            JOptionPane.showMessageDialog(appGUI.frame,msg);
        }
    }

    /**
     * Handler for shortcuts, ie. show events from one specified region. No additional action needed, updates content panel.
     * @param region Array of type String with event names.
     */
    public void showOneRegion(String[] region){
        JPanel jPanel;
        JLabel jLabel;
        Controller.tables.clear();
        Controller.chosenEvents.clear();
        Controller.chosenEvents.addAll(Arrays.asList(region));
        // we're using lenght of arrays since every region has fixed amount of events, small probability of getting new events in old regions
        switch (region.length){
            case 14 -> {
                jPanel = new Events(appGUI).coreEvents();
                jLabel = new JLabel(appGUI.langBundle.getString("labelCore"));
            }
            case 4 -> {
                jPanel = new Events(appGUI).hotEvents();
                jLabel = new JLabel(appGUI.langBundle.getString("labelHot"));
            }
            case 7 -> {
                jPanel = new Events(appGUI).pofEvents();
                jLabel = new JLabel(appGUI.langBundle.getString("labelPof"));
            }
            case 6 -> {
                jPanel = new Events(appGUI).eodEvents();
                jLabel = new JLabel(appGUI.langBundle.getString("labelEod"));
            }
            case 20 -> {
                jPanel = new Events(appGUI).lwsEvents();
                jLabel = new JLabel(appGUI.langBundle.getString("labelLws"));
            }
            default -> {
                JOptionPane.showMessageDialog(
                        appGUI.contentPanel,
                        appGUI.langBundle.getString("ioexception"));
                return;
            }
        }
        this.appGUI.contentPanel.removeAll();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setLabelSettings(jLabel);

        this.appGUI.contentPanel.add(jLabel, gbc);
        gbc.gridy += 1;
        this.appGUI.contentPanel.add(jPanel, gbc);
        this.appGUI.contentPanel.updateUI();
    }

}

