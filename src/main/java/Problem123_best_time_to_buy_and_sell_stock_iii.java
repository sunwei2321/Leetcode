public class Problem123_best_time_to_buy_and_sell_stock_iii {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] matrix = new int[3][prices.length];
        for(int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i]- matrix[k-1][i-1]);
                matrix[k][i] = Math.max(matrix[k][i-1], prices[i]-min);
            }
        }

        return matrix[2][prices.length-1];
    }
}
