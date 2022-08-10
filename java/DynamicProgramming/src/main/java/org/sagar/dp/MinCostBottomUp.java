package org.sagar.dp;

import java.util.Hashtable;
import java.util.Map;

public class MinCostBottomUp {

    public static int minCost(int[] costs) {
        int n = costs.length;
        Map<Integer, Integer> dp = new Hashtable<>();

        for (int k = 0; k < n; k++) {
            Integer calculatedCost;
            if (k==0|k==1)
                calculatedCost = costs[k];
            else {
                calculatedCost = costs[k]+Math.min(dp.get(k-1), dp.get(k-2));
            }

            dp.put(k, calculatedCost);

        }

        return Math.min(dp.get(n-1), dp.get(n-2));
    }
}
