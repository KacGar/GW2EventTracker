package com.et4;

import com.et4.controls.Controller;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.lang.AppBundle;
import com.logHandlers.WarningHandler;
import com.et4.controls.menuController.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 * Main GUI for application. Extends {@link JFrame} and initializes every component, logger and preferences.
 * Handles simple basic configuration like reading from node preferences or loading proper resource language boundle.
 * {@see ResourceBoundle}
 * {@see Logger}
 * {@see Preferences}
 */
public class Et4GUI extends JFrame {
    JPanel wrapper = new JPanel();
    public JPanel contentPanel;
    public JScrollPane jScrollPane;
    public Logger logger;
    public JFrame frame;
    public Preferences root;
    public Preferences node;
    public ResourceBundle langBundle;
    private final String[] menuItemAccKey = {"ctrl 1", "ctrl 2", "ctrl 3", "ctrl 4", "ctrl 5", "ctrl 6", "ctrl 7", "ctrl 8"};


    public enum FrameBounds {
        LEFT, TOP, HEIGHT, WIDTH
    }

    /**
     * Default constructor with no parameters.
     * Initializing of logger, resource bundle and GUI itself are delegated to private methods. \n
     * Text displayed in components is taken from language resource bundle.
     */
    public Et4GUI(){
        // init logger
        logger = Logger.getLogger("com.et4.Et4GUI");
        WarningHandler.setupLogger(logger);
        //init preferences
        root = Preferences.userRoot();
        node = root.node("com.et4.Et4GUI");
        //init resource bundle
        langBundle = AppBundle.getResBundle(logger, node, this);
        // init frame - delegated to method
        frame = initGUI(this);
    }

    /**
     * Main method for initializing GUI components. \n
     * First reads values from {@link Preferences} node and sets size for frame.
     * Adds window listener on closing by creating anonymous class of {@link WindowAdapter} and ovverriding windowClosing method.
     * Later initializes menu components and wrapper component which holds all contents.
     * Content panel is put inside {@link JScrollPane} as its view.
     * On default content panel displays all events unless user chose to display his favorites (setting can be set after launching program at least once).\n
     * At the end {@link Timer} object is created to start countdown.
     * @param frame JFrame class or its subclass
     * @return GUI object of JFrame type (Et4GUI)
     */
    private JFrame initGUI(JFrame frame){
        logger.log(Level.FINE, "Logger zainicjonowany");
        frame.setTitle("Event Tracker V4");
        // take last values from saved preferences
        int left = node.getInt("frameLeft", defaultSize(FrameBounds.LEFT, root));
        int top = node.getInt("frameTop", defaultSize(FrameBounds.TOP, root));
        int height = node.getInt("frameHeight", defaultSize(FrameBounds.HEIGHT, root));
        int width = node.getInt("frameWidth", defaultSize(FrameBounds.WIDTH, root));
        frame.setBounds(left, top, width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // save frame position and size values into node
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // save preferences on closing
                node.putInt("frameLeft", frame.getX());
                node.putInt("frameTop", frame.getY());
                node.putInt("frameHeight", frame.getHeight());
                node.putInt("frameWidth", frame.getWidth());
                logger.log(Level.FINE, "Frame setting saved");
            }
        });


        //menu init
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuF = new JMenu(langBundle.getString("menuFile"));
        JMenu menuE = new JMenu(langBundle.getString("menuEvent"));
        JMenu menuH = new JMenu(langBundle.getString("menuHelp"));

        //menu items
        JMenuItem menuItemOpen = new JMenuItem(langBundle.getString("menuItemOpen"));
        JMenuItem menuItemSave = new JMenuItem(langBundle.getString("menuItemSave"));
        JMenuItem menuItemLoadOnStart = new JMenuItem(langBundle.getString("menuItemLoadOnStart"));
        menuF.add(menuItemOpen);
        menuF.add(menuItemSave);
        menuF.add(menuItemLoadOnStart);

        JMenuItem menuItemAll = new JMenuItem(langBundle.getString("menuItemAll"));
        JMenuItem menuItemCore = new JMenuItem(langBundle.getString("menuItemCore"));
        JMenuItem menuItemHoT = new JMenuItem(langBundle.getString("menuItemHoT"));
        JMenuItem menuItemPoF = new JMenuItem(langBundle.getString("menuItemPoF"));
        JMenuItem menuItemEoD = new JMenuItem(langBundle.getString("menuItemEoD"));
        JMenuItem menuItemLWS = new JMenuItem(langBundle.getString("menuItemLWS"));
        JMenuItem menuItemFavorites = new JMenuItem(langBundle.getString("menuItemFavorites"));
        JMenuItem menuItemChoosing = new JMenuItem(langBundle.getString("menuItemChoosing"));
        menuE.add(menuItemAll);
        menuE.add(menuItemCore);
        menuE.add(menuItemHoT);
        menuE.add(menuItemPoF);
        menuE.add(menuItemEoD);
        menuE.add(menuItemLWS);
        menuE.add(menuItemFavorites);
        menuE.add(menuItemChoosing);

        JMenuItem menuItemAbout = new JMenuItem(langBundle.getString("menuItemAbout"));
        JMenuItem menuItemLang = new JMenuItem(langBundle.getString("menuItemLang"));
        menuH.add(menuItemAbout);
        menuH.add(menuItemLang);

        // setup listeners, delegating to outside method
        JMenu[] allMenu = {menuF, menuE, menuH};
        setupMenuListeners(allMenu, this);
        setupMenuItemKeyStrokes(menuE);
        jMenuBar.add(menuF);
        jMenuBar.add(menuE);
        jMenuBar.add(menuH);
        frame.setJMenuBar(jMenuBar);


        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        // if user choose to start with his favorites, otherwise default
        if (node.get("loadOnStart", "n").equalsIgnoreCase("y")){
            // if path to file is actually set, otherwise default
            if ( !(node.get("pathToFavorites", "").equalsIgnoreCase("")) ){
                Controller.getFavPanel(this);
                jScrollPane = new JScrollPane(contentPanel);
            } else {
                jScrollPane = Controller.getDefaultPanel(this);
            }
        } else {
            jScrollPane = Controller.getDefaultPanel(this);
        }
        wrapper.setLayout(new BorderLayout());
        wrapper.add(jScrollPane, BorderLayout.CENTER);

        // sets timer to start countdown
        Timer timer = new Timer(1000, new Controller(this));
        timer.setActionCommand("countdown");
        timer.start();

        frame.add(wrapper);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Method takes last saved values from user node.
     * If value don't exist or is set on zero then method takes values from user monitor display to put roughly window on middle.
     * @param frameBounds Enum parameter of frame bounds ie. TOP,LEFT,WIDTH,HEIGHT
     * @param node User node of {@link Preferences} class
     * @return int value of requested enum value
     */
    private static int defaultSize(FrameBounds frameBounds, Preferences node){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int result = 0;
        switch (frameBounds){
            case LEFT -> {if (node.getInt("frameLeft",0) == 0) return result = (int) (toolkit.getScreenSize().getWidth() / 4);}
            case TOP -> {if (node.getInt("frameTop",0) == 0) return result = (int) (toolkit.getScreenSize().getHeight() / 4);}
            case HEIGHT -> {if (node.getInt("frameHeight",0) == 0) return result = (int) (int) (toolkit.getScreenSize().getHeight() / 2);}
            case WIDTH -> {if (node.getInt("frameWidth",0) == 0) return result = (int) (int) (toolkit.getScreenSize().getWidth() / 2);}
        }
        return result;
    }

    /**
     * Method setting action listeners for every {@link JMenuItem} of every {@link JMenu}.
     * @param menus Array of JMenu objects that holds JMenuItems
     * @param frame GUI of application
     */
    private void setupMenuListeners(JMenu[] menus, Et4GUI frame){
        for (JMenu menu : menus) {
            for (int j = 0; j < menu.getItemCount(); j++) {
                menu.getItem(j).addActionListener(new MenuHandlers(frame));
            }
        }
    }

    /**
     * Method setting shortcuts (accelerators, keystrokes) for quick use for displaying events ie. all events, one region, quick load etc.
     * Not for open use, only upon initialization of GUI. Used keystrokes are hard coded, so calling method with different passed parameter
     * will set same keystrokes to probably already set when GUI was initialized.
     * @param menu JMenu which holds items upon which accelerators are set.
     */
    private void setupMenuItemKeyStrokes(JMenu menu){
        for (int i = 0; i < menu.getItemCount(); i++){
            menu.getItem(i).setAccelerator(KeyStroke.getKeyStroke(menuItemAccKey[i]));
        }
    }

    /**
     * Main method of application. Tries to use custom LaF, if it fails uses standard JAVA LaF
     * @param args Standard parameter of lovely main method. No args are used.
     */
    public static void main(String[] args) {
        // standard invocation of swing elements
        SwingUtilities.invokeLater(() -> {
            try {
                //loading custom Look and Feel
                FlatArcDarkContrastIJTheme.setup();
                new Et4GUI();
            } catch( Exception ex ) {
                //custom LaF failed, then launch with standard LaF
                new Et4GUI();
            }
        });
    }
}
