import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem57_insert_interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            return Arrays.asList(newInterval);
        }

        List<Interval> result = new ArrayList<>();

        int count = 0;
        while(count < intervals.size() && intervals.get(count).end < newInterval.start) {
            result.add(intervals.get(count));
            count++;
        }

        Interval merged = newInterval;
        while(count < intervals.size() && intervals.get(count).start <= newInterval.end) {
            merged = new Interval(
                    Math.min(intervals.get(count).start, merged.start),
                    Math.max(intervals.get(count).end, merged.end));
            count++;
        }

        result.add(merged);

        while(count < intervals.size()) {
            result.add(intervals.get(count));
            count++;
        }
        return result;
    }
}
