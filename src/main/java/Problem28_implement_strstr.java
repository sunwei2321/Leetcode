public class Problem28_implement_strstr {
    public int strStr(String haystack, String needle) {

        if (needle==null||needle.equals("")) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < (haystack.length() - needle.length()); i++) {
            int first = i;
            int second = 0;
            while (first < haystack.length() && second < needle.length()&& haystack.charAt(first) == needle.charAt(second)) {
                first++;
                second++;
            }
            if (second == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
