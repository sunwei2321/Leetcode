public class Problem151_reverse_words_in_a_string {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverseWord(chars);
        int length = removeSpace(chars);
        return new String(chars).substring(0, length);
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char c = chars[start];
            chars[start++] = chars[end];
            chars[end--] = c;
        }
    }

    private void reverseWord(char[] chars) {
        int i = 0;
        int j = 0;
        while(i < chars.length) {
            while(i < chars.length && chars[i] == ' ') {
                i++;
            }

            j = i;
            while(j < chars.length && chars[j] != ' ') {
                j++;
            }

            reverse(chars, i, j - 1);
            i = j;
        }
    }

    private int removeSpace(char[] chars) {
        int i = 0;
        int j = 0;
        while(j < chars.length) {
            while(j < chars.length && chars[j] == ' ') {
                j++;
            }
            while(j < chars.length && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            while(j < chars.length && chars[j] == ' ') {
                j++;
            }
            if (j < chars.length) {
                chars[i++] = ' ';
            }
        }
        return i;
    }
}
