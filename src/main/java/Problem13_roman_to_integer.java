public class Problem13_roman_to_integer {
    public int romanToInt(String s) {
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int[] number = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String sub = new String(s);
        int result = 0;
        for (int i = 0; i < romans.length;) {
            String roman = romans[i];
            if (sub.startsWith(roman)) {
                result += number[i];
                sub = sub.substring(roman.length());
            } else {
                i++;
            }
        }
        return result;
    }
}
