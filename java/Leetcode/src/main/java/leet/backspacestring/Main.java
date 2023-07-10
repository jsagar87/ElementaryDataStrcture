package leet.backspacestring;

import java.util.Stack;

class Solution2 {

    public int backShift(String s, int ptr) {
        while (ptr >=0 && s.charAt(ptr) == '#') {
            int count = 0;
            while (ptr > -1 && s.charAt(ptr) == '#') {
                count++;
                ptr--;
            }
            ptr -= count;
        }
        return ptr;
    }
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length()-1, p2=t.length()-1;

        while (p1>=0 || p2 >=0) {
            if (s.charAt(p1)==t.charAt(p2)) {
               if (s.charAt(p1) == '#') {
                   p1 = backShift(s, p1);
                   p2 = backShift(t, p2);
               } else {
                   p1--;
                   p2--;
               }

            } else return false;
        }

        if (p1>=0 || p2>=0)
            return false;
        else return true;
    }
}
class Solution1 {
    public Stack backspacedString(String s) {
        Stack stack = new Stack();
        for (char ss : s.toCharArray()) {
            if (ss == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(ss);
            }
        }
        return stack;
    }
    public boolean backspaceCompare(String s, String t) {
        Stack stack1 = backspacedString(s);
        Stack stack2 = backspacedString(t);

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()){
            Character x = (Character) stack1.pop();
            Character y = (Character) stack2.pop();
            if (x!=y) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
//        Solution1 soln1 = new Solution1();
//        boolean result1 = soln1.backspaceCompare("ab#c","ad#c");
//        System.out.println(result1);
//
        Solution2 soln2 = new Solution2();
//        boolean result2 = soln2.backspaceCompare("ab#c","ad#c");
//        System.out.println(result2);

        boolean result3 = soln2.backspaceCompare("xab##","xyab###c#d#");
        System.out.println(result3);
    }
}
