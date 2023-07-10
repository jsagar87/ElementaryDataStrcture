package org.example;

import java.util.ArrayList;
import java.util.List;
//import edu.princeton.cs.algs4.MinPQ;

/**
 * Hello world!
 *
 */
class Person {
    private String fname;
    private String lname;
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Person> persons = new ArrayList<>();
        int i = 0;
        while  (true) {
            Person p = new Person("Blaise", "Pascal");
            persons.add(p);
            if (i>10000) {
                persons = new ArrayList<>();
                i=0;
            }
        }

    }
}
