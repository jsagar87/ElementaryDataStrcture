package org.sagar.dp;

import java.util.Hashtable;
import java.util.Map;

public class MinCostBottomUpImprovement {

    public static int minCost(int[] costs) {
        int n = costs.length;

        Integer cur,prev;
        prev = costs[0];
        cur = costs[1];
        for (int k = 2; k < n; k++) {
            Integer calculatedCost;
            calculatedCost = costs[k]+Math.min(prev, cur);
            prev = cur;
            cur = calculatedCost;
        }

        return Math.min(cur, prev);
    }
}
