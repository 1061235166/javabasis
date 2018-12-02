package com.k.算法;

/**
 * 买入卖出股票的最大利润
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Created by k on 2018/12/2.
 */
public class BestTimetoBuyandSellStockII {


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    /**
     * 网上的解法，自己一下子没想出来
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i])
                total += prices[i+1]-prices[i];
        }

        return total;
    }
}
