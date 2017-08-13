public int maxProfit(int[] prices) {
    int buy = Integer.MAX_VALUE;
    int profit = 0;

    for (int i = 0; i < prices.length; i ++) {
        if (prices[i] < buy) {
            buy = prices[i];
        } else if (prices[i] - buy > profit) {
            profit = prices[i] - buy;
        }
    }
    return profit;
}
