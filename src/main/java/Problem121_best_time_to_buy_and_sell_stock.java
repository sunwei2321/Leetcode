public class Problem121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int low = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < low) {
                low = price;
            }

            if (price - low > profit) {
                profit = price - low;
            }
        }
        return profit;
    }
}
