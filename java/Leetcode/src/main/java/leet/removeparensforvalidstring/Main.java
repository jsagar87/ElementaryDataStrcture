package leet.removeparensforvalidstring;

import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        String[] str = s.split("");
        StringBuilder res = new StringBuilder();
        Stack stack  = new Stack();

        for (int i =0; i<s.length(); i++) {

            String ss = str[i];
            if (ss.equals("(")) {
                stack.push(i);
            }
            else if (ss.equals(")") && stack.size() != 0) {
                stack.pop();
            } else  if(ss.equals(")")) {
                str[i] = "";
            }
        }

        while (!stack.isEmpty()) {
            int x = (int)stack.pop();
            str[x] = "";
        }

        for (String ss : str) {
            if (ss!="" || ss.isEmpty()) {
                res.append(ss);
            }
        }
        return res.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.minRemoveToMakeValid(")lee(t(c)o)de)");
        System.out.println(result);
        result = s.minRemoveToMakeValid("))((r");
        System.out.println(result);
    }
}
