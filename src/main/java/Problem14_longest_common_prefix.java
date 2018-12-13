public class Problem14_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }

        int low = 0;
        int high = min;
        while(low <= high) {
            int middle = (low + high)/2;
            if (isPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low+high)/2);
    }

    private boolean isPrefix(String[] strs, int length) {
        String sub = strs[0].substring(0, length);
        for (String str : strs) {
            if (!str.startsWith(sub)) {
                return false;
            }
        }
        return true;
    }
}
