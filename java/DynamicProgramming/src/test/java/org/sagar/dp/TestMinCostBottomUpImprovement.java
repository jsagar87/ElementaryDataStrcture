package org.sagar.dp;

import org.junit.Assert;
import org.junit.Test;

public class TestMinCostBottomUpImprovement {
    @Test
    public void testMinCost(){
        MinCostBottomUpImprovement mincostSol = new MinCostBottomUpImprovement();
        int[] costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        int result = mincostSol.minCost(costs);
        Assert.assertEquals(6, result);
    }
    @Test
    public void testMinCost2(){
        MinCostBottomUpImprovement mincostSol = new MinCostBottomUpImprovement();
        int[] costs = new int[]{10, 15, 20};
        int result = mincostSol.minCost(costs);
        Assert.assertEquals(15, result);
    }
}
