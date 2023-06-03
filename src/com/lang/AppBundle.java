package com.lang;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 * Class for handling only one thing - loading resource bundle with language properties. Has private constructor and one public static method.
 * For now only two languages are handled, Polish and English.
 */
public class AppBundle {

    private AppBundle(){}

    /**
     * Method to retrieve resource bundle with language properties which uses {@link Logger} to log errors, {@link Preferences} node to check what language to return
     * and {@link JFrame} component upon which dialog with errors are displayed.
     * @param logger Main application logger
     * @param node Main preferences object with user node
     * @param frame application GUI on which display dialog messages
     * @return {@link ResourceBundle} object with language properties
     */
    public static ResourceBundle getResBundle(Logger logger, Preferences node, JFrame frame){
        ResourceBundle bundle = null;
        try {
            if (node.get("language", "en").equalsIgnoreCase("pl")){
                return bundle = ResourceBundle.getBundle("com.lang.EtGUILangResource_pl_PL");
            } else {
                return bundle = ResourceBundle.getBundle("com.lang.EtGUILangResource_US");
            }

        } catch (NullPointerException ex){
            logger.log(Level.WARNING, ex.getMessage());
            String msg;
            if (Locale.getDefault().getDisplayLanguage().equalsIgnoreCase("polski")){
                msg = "Odnośnik do pliku językowego nie istnieje. Prawdopodobnie plik property w folderze 'lang' nie istnieje.";
                JOptionPane.showMessageDialog(frame,msg);
            }
            else {
                msg = "Pointer to language file don't exists. Probably property file in 'lang' folder don't exist.";
                JOptionPane.showMessageDialog(frame,msg);
            }
            System.exit(0);

        } catch (java.util.MissingResourceException ex){
            logger.log(Level.WARNING, ex.getMessage());
            String msg;
            if (Locale.getDefault().getDisplayLanguage().equalsIgnoreCase("polski")){
                msg = "Odnośnik do zasobu językowego nie istnieje. Prawdopodobnie adres zasobu jest błędny";
                JOptionPane.showMessageDialog(frame,msg);
            }
            else {
                msg = "Pointer to package language is missing. Probably pathname to bundle is invalid.";
                JOptionPane.showMessageDialog(frame,msg);
            }
            System.exit(0);
        }
        return bundle;
    }
}
