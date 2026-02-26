class Solution {

    public int myAtoi(String s) {
        int i = skipSpaces(s, 0);
        if (i == s.length()) return 0;

        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        return buildNumber(s, i, 0, sign);
    }

    // Skip leading spaces recursively
    private int skipSpaces(String s, int i) {
        if (i == s.length() || s.charAt(i) != ' ')
            return i;
        return skipSpaces(s, i + 1);
    }

    // Build number recursively
    private int buildNumber(String s, int i, long num, int sign) {

        if (i == s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(num * sign);
        }

        int digit = s.charAt(i) - '0';
        num = num * 10 + digit;

        // overflow check
        if (sign * num >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (sign * num <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return buildNumber(s, i + 1, num, sign);
    }
}