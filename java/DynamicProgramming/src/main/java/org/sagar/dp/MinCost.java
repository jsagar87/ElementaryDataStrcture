package org.sagar.dp;

public class MinCost {
    public static int minCost(int[] costs) {
        int n = costs.length;
        return Math.min(minCost(n-1, costs),minCost(n-2, costs));
    }

    private static int minCost(int i, int[] costs) {
        if (i < 0) return 0;
        if ( i== 0 | i == 1) return costs[i];
        return costs[i] + Math.min(minCost(i-1, costs), minCost(i-2, costs));
    }
}
