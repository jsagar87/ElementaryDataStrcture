package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Solution sol = new Solution();
        String[]  words = new String[]{"area","lead","wall","lady","ball", "tall"};
        sol.wordSquares(words);
        System.out.println(words[0]);
    }
}
