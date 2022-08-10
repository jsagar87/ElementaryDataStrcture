package org.sagar.dp;

import org.junit.Assert;
import org.junit.Test;

public class TestMinCost {
    @Test
    public void testMinCost(){
        int[] costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        int result = MinCost.minCost(costs);
        Assert.assertEquals(6, result);
    }
    @Test
    public void testMinCost2(){
        int[] costs = new int[]{10, 15, 20};
        int result = MinCost.minCost(costs);
        Assert.assertEquals(15, result);
    }
}
