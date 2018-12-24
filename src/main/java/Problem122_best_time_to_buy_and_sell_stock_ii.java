public class Problem122_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
