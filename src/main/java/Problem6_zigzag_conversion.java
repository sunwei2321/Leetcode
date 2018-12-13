import java.util.ArrayList;
import java.util.List;

public class Problem6_zigzag_conversion {
    public String convert(String s, int numRows) {
        if (s.isEmpty() || numRows == 1) {
            return s;
        }
        List<StringBuilder> subs = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            subs.add(new StringBuilder());
        }

        boolean down = true;
        int current = 0;
        for(char c : s.toCharArray()) {
            subs.get(current).append(c);
            if(down) {
                if (current == numRows - 1) {
                    down = false;
                }
            } else {
                if (current == 0) {
                    down = true;
                }
            }

            if (down) {
                current++;
            } else {
                current--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sub : subs) {
            sb.append(sub);
        }
        return sb.toString();
    }
}
