import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem56_merge_intervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = result.get(result.size()-1);
            Interval current = intervals.get(i);
            if (last.start <= current.start && current.start <= last.end) {
                last.end = Math.max(current.end, last.end);
            } else{
                result.add(current);
            }
        }
        return result;
    }


}
