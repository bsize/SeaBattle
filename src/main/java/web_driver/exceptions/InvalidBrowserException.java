package web_driver.exceptions;

import web_driver.logger.Logger;

public class InvalidBrowserException extends Exception {
    private static Logger logger = Logger.getInstance();

    public InvalidBrowserException() {
        logger.info(logger.getLoc("loc.browser.name.wrong"));
    }
}



