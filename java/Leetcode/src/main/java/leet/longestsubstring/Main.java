package leet.longestsubstring;


import java.util.HashMap;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int strLen = s.length();
        if (strLen == 0 | strLen == 1) return strLen;

        int l =0, longest = 0;
        HashMap<Character,Integer> seen = new HashMap<>();
        for ( int r=0; r<strLen; r++ ) {  // au
            Character cur = s.charAt(r);
            Integer seenAtIdx = seen.get(cur);
            if ( seenAtIdx != null && seenAtIdx >= l ) {
                l = seenAtIdx + 1;
            }
            seen.put(cur, r);
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}

public class Main {
    public static void main(String[] args) {
        String str = new String("abcabcbb");
//        String str = new String("au");
//        String str = new String("abcbdaac");
//        String str = new String("abracadabra");
        int actual = Solution.lengthOfLongestSubstring(str);
        int expected = 3;
//        int expected = 2;
//        int expected = 4;
//        int expected = 4;
        System.out.println(actual);
        if (actual == expected) {

            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
