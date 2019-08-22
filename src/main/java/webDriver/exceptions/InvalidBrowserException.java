package webDriver.exceptions;

import webDriver.Logger.Logger;

public class InvalidBrowserException extends Exception {
    private static Logger logger = Logger.getInstance();

    public InvalidBrowserException() {
        logger.info(logger.getLoc("loc.browser.name.wrong"));
    }
}



