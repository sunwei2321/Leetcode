import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem119_pascals_triangle_ii {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j < result.size() - 1; j++) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
            result.add(0, 1);
        }
        return result;
    }
}
