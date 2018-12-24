import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem149_max_points_on_a_line {
    public int maxPoints(Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int samey = 1;
            int samep = 0;
            Map<Double, Integer> slopeMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samep++;
                }

                if (points[i].y == points[j].y) {
                    samey++;
                    continue;
                }

                double slope = (double) (points[i].x - points[j].x)/(double)(points[i].y - points[j].y);
                if (slopeMap.containsKey(slope)) {
                    slopeMap.put(slope, slopeMap.get(slope) + 1);
                } else {
                    slopeMap.put(slope, 2);
                }

                result = Math.max(result, slopeMap.get(slope) + samep);
            }
            result = Math.max(result, samey);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.print(new Problem149_max_points_on_a_line().maxPoints(new Point[]{
                new Point(0, 0),
                new Point(94911151, 94911150),
                new Point(94911152, 94911151)}));
    }
}