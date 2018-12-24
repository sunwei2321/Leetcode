import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> track = new ArrayList<>();
        if (triangle.size() == 0) {
            return 0;
        }

        track.add(Integer.MAX_VALUE);
        track.addAll(triangle.get(0));
        track.add(Integer.MAX_VALUE);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                track.set(j, Math.min(track.get(j), track.get(j + 1)) + current.get(j));
            }
            if (i != triangle.size() - 1) {
                track.add(0,Integer.MAX_VALUE);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : track) {
            min = Math.min(i, min);
        }
        return min;
    }

    @Test
    public void test() {
        System.out.println(new Problem120_triangle().minimumTotal(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3,4),
                        Arrays.asList(6,5,7),
                        Arrays.asList(4,1,8,3))));
    }
}
