import org.testng.annotations.Test;

import java.util.Arrays;

public class Problem135_candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
            }
            sum += candies[i-1];
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(new Problem135_candy().candy(new int[]{1,3,2,2,1}));
    }
}
