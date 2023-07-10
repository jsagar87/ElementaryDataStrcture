package leet.trap.rainwater;


class Solution {
    public int trap(int[] height) {
        int total = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length-1;

        while (left<=right) {
            if (leftMax < rightMax) {
                if (height[left]<leftMax) {
                    total += (leftMax - height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right]>rightMax) {
                    rightMax = height[right];
                } else {
                    total += (rightMax - height[right]);
                }
                right--;
            }
        }
        return total;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
        System.out.println("TEST pass? : "+ (6==result));
    }
}
