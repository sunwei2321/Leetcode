public class Problem67_add_binary {
    public String addBinary(String a, String b) {
        int a1 = a.length() - 1;
        int b1 = b.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(a1 >= 0 && b1 >= 0) {
            int val1 = a.charAt(a1) - '0';
            int val2 = b.charAt(b1) - '0';
            int sum = val1 + val2 + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            a1--;
            b1--;
        }

        while(a1 >= 0) {
            int val1 = a.charAt(a1) - '0';
            int sum = val1 + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            a1--;
        }

         while (b1 >= 0) {
             int val2 = b.charAt(b1) - '0';
             int sum = val2 + carry;
             sb.insert(0, sum % 2);
             carry = sum / 2;
             b1--;
         }

         if (carry > 0) {
             sb.insert(0, carry);
         }
         return sb.toString();
    }
}
