import java.util.ArrayList;
import java.util.List;

public class Problem93_restore_ip_addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIPAddresses0(result, "", 0, s, 0);
        return result;
    }

    private void restoreIPAddresses0(List<String> result, String track, int index, String s, int count) {
        if (count == 4) {
            if (index == s.length()) {
                result.add(track);
            } else {
                return;
            }
        }

        for (int i = 1; i < 4; i++) {
            if (i + index > s.length()) {
                return;
            }
            String sub = s.substring(index, index + i);
            if ((sub.startsWith("0") && i > 1)||Integer.valueOf(sub) > 255) {
                return;
            } else {
                if (count == 0) {
                    restoreIPAddresses0(result, sub, index + i, s, count + 1);
                } else {
                    restoreIPAddresses0(result, track + "." + sub, index + i, s, count + 1);
                }
            }
        }
    }
}
