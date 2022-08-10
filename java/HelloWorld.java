//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

public class HelloWorld{

    public static void main(String args[]) {
//        StdOut.println("Hello, World");
        System.out.println("Hello, World");
        Scanner scan = new Scanner(System.in);
        int mynumber = scan.nextInt();
        String mystring = scan.next();
        System.out.println("You enterd integer " + mynumber);
        System.out.println("You enterd String " + mystring);
    }
}