class Solution {
    // 233. Number of Digit One
    public int countDigitOne(int n) {
        int count = 0;
        long place = 1; // This will represent the current digit place (1, 10, 100, etc.)

        while (place <= n) {
            // Split n into three parts:
            // left = higher digits, current digit = middle digit, right = lower digits
            long left = n / (place * 10); // Higher part of the number
            long currentDigit = (n / place) % 10; // Current digit at the current place
            long right = n % place; // Lower part of the number

            // Count the number of '1's contributed by the current digit place
            if (currentDigit == 0) {
                count += left * place; // If the current digit is 0, count only the higher part
            } else if (currentDigit == 1) {
                count += left * place + right + 1; // If the current digit is 1, count all numbers formed by left and right
            } else {
                count += (left + 1) * place; // If the current digit is greater than 1, count all numbers formed by left and right
            }

            // Move to the next digit place (10 times larger)
            place *= 10;
        }

        return count;
    }
}
