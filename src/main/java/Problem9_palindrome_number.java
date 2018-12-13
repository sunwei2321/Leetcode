import org.testng.annotations.Test;

public class Problem9_palindrome_number {
    public boolean isPalindrome(int x) {
       if (x >= 0) {
           return isPalindrome0(x);
       } else {
           return false;
       }
    }

    public boolean isPalindrome0(int x) {
        int s = 1;
        int c = x;
        while(c/s >= 10) {
            s*=10;
        }

        int t = x;
        while(t > 0) {
            int h = t/s;
            int l = t%10;
            if (h!=l) {
                return false;
            }
            t = (t%s)/10;
            s = s/100;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(new Problem9_palindrome_number().isPalindrome(1000021));
        System.out.println(new Problem9_palindrome_number().isPalindrome(1212));
        System.out.println(new Problem9_palindrome_number().isPalindrome(1221));
    }
}
