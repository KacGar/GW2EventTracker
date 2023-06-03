package com.et4.controls.menuController;

import com.et4.content.Events;
import com.et4.controls.Controller;
import com.et4.Et4GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Handler for each menu item of each menu, extends Controller class.
 */
public class MenuHandlers extends Controller {

    /**
     * Main constructor where uses parent constructor to assing GUI object
     * @param appGUI GUI object of type Et4GUI (extends JFrame)
     */
    public MenuHandlers(Et4GUI appGUI) { super(appGUI); }

    /**
     * Overridden method for action events which handles every action fired from {@link JMenuItem} item.
     * Gets proper key assigned in language bundle for items and checks if action command value contains key value.
     * Every action delegates to proper method.
     * @param e {@link ActionEvent} object
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();
        if ( s.contains(appGUI.langBundle.getString("menuItemOpen")) ) { openFile(); }
        if ( s.contains(appGUI.langBundle.getString("menuItemSave"))){ saveCurrentShownEvents();}
        if ( s.contains(appGUI.langBundle.getString("menuItemLoadOnStart")) ) {
            int status = JOptionPane.showConfirmDialog(appGUI.frame,
                    appGUI.langBundle.getString("loadOnStart"));
            if (status == JOptionPane.YES_OPTION){
                appGUI.node.put("loadOnStart", "y");
            } else if (status == JOptionPane.NO_OPTION){
                appGUI.node.put("loadOnStart", "n");
            }
            JOptionPane.showMessageDialog(appGUI.frame, "Setting saved!");
        }
        if ( s.contains(appGUI.langBundle.getString("menuItemAll")) ) {
            Controller.chosenEvents.clear();
            this.appGUI.contentPanel.removeAll();
            this.appGUI.contentPanel = new Events(appGUI).allEvents();
            this.appGUI.contentPanel.updateUI();
        }

        if ( s.contains("Show") | s.contains("Pokaż")){
            Events events = new Events(appGUI);
            if ( s.contains(appGUI.langBundle.getString("menuItemCore")) ) { events.showOneRegion(events.getCore()); }
            if ( s.contains(appGUI.langBundle.getString("menuItemHoT")) ) { events.showOneRegion(events.getHot()); }
            if ( s.contains(appGUI.langBundle.getString("menuItemPoF")) ) { events.showOneRegion(events.getPof()); }
            if ( s.contains(appGUI.langBundle.getString("menuItemEoD")) ) { events.showOneRegion(events.getEod()); }
            if ( s.contains(appGUI.langBundle.getString("menuItemLWS")) ) { events.showOneRegion(events.getLws()); }
        }
        if ( s.contains(appGUI.langBundle.getString("menuItemFavorites")) ) { quickLoadFavorites(); }
        if ( s.contains(appGUI.langBundle.getString("menuItemChoosing")) ) { choosingEventsPanel(); }
        if ( s.contains(appGUI.langBundle.getString("menuItemAbout")) ) { showAbout(); }
        if ( s.contains(appGUI.langBundle.getString("menuItemLang")) ) { changeLanguage(); }

    }

    /**
     * Handler for About JMenuItem. Displays simple message using {@link JOptionPane} object.
     */
    private void showAbout(){
        String msg = appGUI.langBundle.getString("about");
        JOptionPane.showMessageDialog(appGUI.frame, msg);
    }

    /**
     * Handler for changing key value (language) in language bundle using confirm dialog box, which will be loaded on next start of application.
     */
    private void changeLanguage(){
        String msg = appGUI.langBundle.getString("language");
        int choice = JOptionPane.showConfirmDialog(appGUI.frame, msg);
        if (choice == JOptionPane.YES_OPTION){
            String key = appGUI.langBundle.getString("currentLang");
            if (key.equalsIgnoreCase("pl")) appGUI.node.put("language", "en");
            else appGUI.node.put("language", "pl");
        }
        JOptionPane.showMessageDialog(appGUI.frame,appGUI.langBundle.getString("changed"));
    }

    /**
     * Creates {@link JCheckBox} from given array string that contains events from specific region, assigns listeners and puts them in provided {@link JPanel}
     * @param arrayEv Array of type <code>String</code> containing event names.
     * @param columnPanel JPanel in which boxes will be added.
     */
    private void setBoxesInColumn(String[] arrayEv, JPanel columnPanel){
        for (String s : arrayEv){
            JCheckBox box = new JCheckBox(s);
            box.addItemListener(new Controller(appGUI));
            box.setFont(box.getFont().deriveFont(15f));
            columnPanel.add(box);
        }
    }

    /**
     * Handler for displaying panel with every event as checkbox that user can choose if wants to display specific events.
     * Layout is handled in 3 columns.
     */
    private void choosingEventsPanel(){
        appGUI.contentPanel.removeAll();
        chosenEvents.clear();
        GridBagConstraints gbc = new GridBagConstraints();
        var column1Panel = new JPanel();
        var column2Panel = new JPanel();
        var column3Panel = new JPanel();

        column1Panel.setLayout(new BoxLayout(column1Panel,BoxLayout.Y_AXIS));
        column2Panel.setLayout(new BoxLayout(column2Panel,BoxLayout.Y_AXIS));
        column3Panel.setLayout(new BoxLayout(column3Panel,BoxLayout.Y_AXIS));

        Events events = new Events(appGUI);
        JLabel jLabel = getLabel("Core");
        JLabel jLabel2 = getLabel("Hot");
        JLabel jLabel3 = getLabel("Pof");
        JLabel jLabel4 = getLabel("Eod");
        JLabel jLabel5 = getLabel("Lws");

        // 1st column
        column1Panel.add(jLabel);
        setBoxesInColumn(events.getCore(), column1Panel);

        // 2n column with three regions
        column2Panel.add(jLabel2);
        setBoxesInColumn(events.getHot(), column2Panel);
        column2Panel.add(jLabel3);
        setBoxesInColumn(events.getHot(), column2Panel);
        column2Panel.add(jLabel4);
        setBoxesInColumn(events.getEod(), column2Panel);

        // 3rd column with lws
        column3Panel.add(jLabel5);
        setBoxesInColumn(events.getLws(), column3Panel);

        //adding columns to content panel - layout with three columns
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        appGUI.contentPanel.add(column1Panel, gbc);
        gbc.gridx+= 1;
        appGUI.contentPanel.add(column2Panel, gbc);
        gbc.gridx+=1;
        appGUI.contentPanel.add(column3Panel, gbc);

        //btn at bottom
        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.gridwidth = 3;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btn = new JButton(appGUI.langBundle.getString("btnShow"));
        btn.setFont(btn.getFont().deriveFont(15f));
        btn.setActionCommand("showChosen");
        btn.addActionListener(new Controller(appGUI));
        appGUI.contentPanel.add(btn,gbc);
        appGUI.contentPanel.updateUI();
    }

    /**
     * Creates a label with fixed settings.
     * @param region String key used to get proper text for label from language bundle ie.(Core,HoT,PoF,EoD,LWS)
     * @return JLabel object
     */
    private JLabel getLabel(String region){
        JLabel jLabel = new JLabel();
        try {
            jLabel.setText(appGUI.langBundle.getString("label" + region));
        } catch (Exception ex){
            // in case of exception of any kind, set text to passed region
            jLabel.setText(region);
            appGUI.logger.log(Level.WARNING, ex.getMessage());
        }
        jLabel.setFont(jLabel.getFont().deriveFont(14f));
        jLabel.setFocusable(false);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setBorder(BorderFactory.createEmptyBorder(12,5,12,5));
        return jLabel;
    }

    /**
     * Delegator for writing data in a file, to reuse code.
     * @param bw BufferedWriter containing file to write in
     * @throws IOException Standard IOException object if I/O error occurs.
     */
    private void writeData(BufferedWriter bw) throws IOException {
        for (String s : chosenEvents){
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }

    /**
     * Handler for saving currently displayed events as fovorites in a file (if path to lastly saved file exists) or location provided by user.
     * By default files are saved in user home directory unless user choose differently.
     */
    private void saveCurrentShownEvents(){
        Thread thread = new Thread(() ->{
            // we try to use last path to saved file, otherwise try get path to default folder in user home directory
            String pathToSaved = appGUI.node.get("pathToFavorites", ".");
            if (pathToSaved.equals("")){
                try {
                    pathToSaved = System.getProperty("user.home") + "\\et4logs";
                } catch (SecurityException e){
                    // null or illegalargument - we dont care about those since we're passing key by hand
                    // in case of exception add record to log and use default path
                    pathToSaved = ".";
                    appGUI.logger.log(Level.WARNING, e.getMessage());
                }
            }
            JFileChooser chooser = new JFileChooser(new File(pathToSaved));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = chooser.showSaveDialog(appGUI.frame);
            if (status == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                try ( BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath() ))) {
                    //check if file exists and overwrite, otherwise create new file then write
                    if ( !(file.exists()) ){
                        if ( file.createNewFile() ){ writeData(bw); }
                    } else {
                        writeData(bw);
                    }
                    //inform user that data was saved
                    JOptionPane.showMessageDialog(appGUI.frame, appGUI.langBundle.getString("fileSavingStatus"));
                    // save path where user choose to save for later use
                    appGUI.node.put("pathToFavorites", file.getPath());
                } catch (IOException ioException) {
                    // show user short msg that something went wrong and write log about exception
                    JOptionPane.showMessageDialog(
                            appGUI.frame,
                            appGUI.langBundle.getString("ioException"),
                            "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    appGUI.logger.log(Level.WARNING, ioException.getMessage());
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Reads event names from provided file and displays panel. Internally filter method is called.
     * @param file File that contains event names
     */
    private void showEventsFromFile(File file){
        try ( BufferedReader br = new BufferedReader(new FileReader(file)) ) {
            Controller.chosenEvents.clear();
            String s;
            while ((s = br.readLine()) != null){
                s.trim();
                chosenEvents.add(s);
            }
            checkAndFilter();

            if (!(chosenEvents.isEmpty())){
                String label = appGUI.langBundle.getString("loadFavorites");
                new Events(appGUI).showSelected(chosenEvents, label);
                // save path with last selected file
                appGUI.node.put("pathToFavorites", file.getPath());
            } else {
                JOptionPane.showMessageDialog(
                        appGUI,
                        appGUI.langBundle.getString("emptyFile"));
                appGUI.node.put("pathToFavorites", "");
            }
        } catch (IOException ioException) {
            // show user that something went wrong and write log
            JOptionPane.showMessageDialog(
                    appGUI,
                    appGUI.langBundle.getString("ioException"),
                    "Alert",
                    JOptionPane.WARNING_MESSAGE);
            appGUI.logger.log(Level.WARNING, ioException.getMessage());
            appGUI.node.put("pathToFavorites", "");
        }
    }

    /**
     * Automatically loads file from lastly saved path without user interaction, after successful read, create panel with user chosen events.
     * If file contained wrong event names or was empty {@link JFileChooser} will open to let user choose different file.
     */
    public void quickLoadFavorites(){
        Thread thread = new Thread(() ->{
            String filePath = appGUI.node.get("pathToFavorites", "");
            if ( !(filePath.equals("")) ) {
                try {
                    File file = new File(filePath);
                    showEventsFromFile(file);
                } catch (NullPointerException e) {
                    appGUI.logger.log(Level.WARNING, e.getMessage());
                    appGUI.node.put("pathToFavorites", "");
                    JOptionPane.showMessageDialog(
                            appGUI,
                            appGUI.langBundle.getString("emptyFile"));
                }
            } else {
                JOptionPane.showMessageDialog(appGUI,
                        appGUI.langBundle.getString("removedPath"));
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Handler for reading file from user defined path and creating panel.
     */
    private void openFile(){
        Thread thread = new Thread(() ->{
            // we try to use last path to saved file, otherwise try get path to default folder in user home directory
            String pathToSaved = appGUI.node.get("pathToFavorites", "");
            if (pathToSaved.equals("")){
                try {
                    pathToSaved = System.getProperty("user.home") + "\\et4logs";
                } catch (SecurityException e){
                    // null or illegalargument - we dont care about those since we're passing key by hand
                    // in case of exception add record to log and use default path
                    pathToSaved = ".";
                    appGUI.logger.log(Level.WARNING, e.getMessage());
                }
            }
            JFileChooser chooser = new JFileChooser(new File(pathToSaved));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = chooser.showSaveDialog(appGUI.frame);
            if (status == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                //read and create panel
                showEventsFromFile(file);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Checks if written element is a correct event name, removes it if not. Since users can send each other modified files, typos can happen.
     */
    private void checkAndFilter() {
        var ev = new Events(appGUI);
        ArrayList<String> allEvents = ev.getAllEvents();
        chosenEvents.removeIf(s -> !(allEvents.contains(s)));
    }

}
