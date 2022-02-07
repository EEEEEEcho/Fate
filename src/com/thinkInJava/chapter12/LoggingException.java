package com.thinkInJava.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


class LoggingExceptions extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingExceptions(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingException extends Exception{
    public static void main(String[] args) {
        try {
            throw new LoggingExceptions();
        }
        catch (LoggingExceptions e){
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingExceptions();
        }
        catch (LoggingExceptions e){
            System.err.println("Caught " + e);
        }
    }
}
