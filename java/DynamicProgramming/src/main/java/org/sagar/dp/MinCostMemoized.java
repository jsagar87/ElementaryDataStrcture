package org.sagar.dp;

import java.util.Hashtable;
import java.util.Map;

public class MinCostMemoized {

    final private Map<Integer, Integer> lookup = new Hashtable<>();

    public int minCost(int[] costs) {
        int n = costs.length;
        return Math.min(minCost(n-1, costs),minCost(n-2, costs));
    }

    private int minCost(int i, int[] costs) {
        if (i < 0) return 0;
        if ( i== 0 | i == 1) return costs[i];

        // Check in lookup
        Integer costI = lookup.get(i);

        if (costI != null)
            return costI;
        else
            costI = costs[i] + Math.min(minCost(i-1, costs), minCost(i-2, costs));

        // Update lookup
        lookup.put(i, costI);

        return costI;
    }
}
