package webDriver.exceptions;
import webDriver.Logger.Logger;

public class NoSuchElementException extends Exception{
    private static Logger logger = Logger.getInstance();
    public NoSuchElementException() {
        logger.info(logger.getLoc("loc.no.element"));
    }

}
