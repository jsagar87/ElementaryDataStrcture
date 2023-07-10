package org.example;

import edu.princeton.cs.algs4.StdIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.info("Hello World!");
        logger.debug("Hello World!");
        int x = StdIn.readInt();
    }
}
