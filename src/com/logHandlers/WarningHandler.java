package com.logHandlers;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;

/**
 * Class implementing {@link Filter} to filter which records are loggable. Implements public methods to return {@link FileHandler} object and setup Logger.
 */
public class WarningHandler implements Filter {

    public WarningHandler(){}

    /**
     * Implementation of {@link Filter} interface
     * @param record LogRecord object ti check whether log ir not.
     * @return Boolean to log or not.
     */
    @Override
    public boolean isLoggable(LogRecord record) {
        boolean isLoggable = false;
        String level = record.getLevel().getName();
        if (level.contains("WARNING") || level.contains("FINE")) isLoggable = true;
        return isLoggable;
    }

    /**
     * Method returning new {@link FileHandler} object with setting to save logs in user home folder
     * @return FileHandler object
     * @throws IOException Standard IOException (and SecurityException)
     */
    public static FileHandler getHandler() throws IOException {
        String logFile = System.getProperty("user.home") + "\\et4logs\\warning.log";
        Path logDirPath = Paths.get(System.getProperty("user.home") + "\\et4logs");
        if (!(Files.exists(logDirPath))){
            Files.createDirectory(logDirPath);
        }
        return new FileHandler(logFile, 0, 5);
    }

    /**
     * Setup of application logger.
     * @param logger Logger to set few settings
     * @return Logger object
     */
    public static Logger setupLogger(Logger logger){
        try {
            logger.addHandler(WarningHandler.getHandler());
        } catch (IOException e) {
            //
            JOptionPane.showMessageDialog(null, "Something wrong went with logger handlers. Default handler used instead.");
            return logger;
        }
        logger.setFilter(new WarningHandler());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        return logger;
    }
}
