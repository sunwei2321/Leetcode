public class Problem125_valid_palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(!isValid(s.charAt(left))) {
                left++;
                if (left == right) {
                    return true;
                }
            }
            while(!isValid(s.charAt(right))) {
                right--;
                if (left == right) {
                    return true;
                }
            }

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c <= 'z' && c >= 'a')||(c <='9' && c >= '0');
    }
}
