package leet.sumoftwo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface Solution{
    int[] twoSum(int[] nums, int target);
}

class Solution1 implements Solution{
    public int[] twoSum(int[] nums, int target) {
        int lent = nums.length;
        for (int p1 = 0; p1 < lent-1; p1++) {
            int numberToFind = target - nums[p1];
            for (int p2 = p1+1; p2 <lent; p2++ ) {
                if (numberToFind == nums[p2]) {
                    return new int[]{p1,p2};
                }
            }
        }
        return new int[]{};
    }
}

class Solution2 implements Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int i = 0;
        while(i< nums.length) {
            Integer X =  nums[i];
            Integer Y = target - X;
            Integer idx = lookup.get(Y);
            if (null != idx) {
                return new int[]{idx,i};
            }
            lookup.put(X, i++);
        }
        return new int[]{};
    }
}

public class Main {

    public static void testharness(Solution soln, int[] nums, int target) {
        int result1[] = soln.twoSum(nums,target);
        Arrays.stream(result1).forEach(e-> System.out.println(e));
    }
    public static void main(String[] args) {
        // TC1
        int nums1[] = new int[]{2,7,11,15};
        int target1 = 9; int expected1[] = new int[]{0,1};
        testharness(new Solution1(), nums1, target1);
        System.out.println("===============================");
        // TC2
        int nums2[] = new int[]{3,2,4};
        int target2 = 6; int expected2[] = new int[]{1,2};
        testharness(new Solution1(), nums2, target2);
        System.out.println("===============================");
        // TC1 -sol2
        testharness(new Solution1(), nums1, target1);
        System.out.println("===============================");
        // TC2 -sol2
        testharness(new Solution2(), nums2, target2);
    }
}
