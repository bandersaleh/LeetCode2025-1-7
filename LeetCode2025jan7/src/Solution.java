import java.util.*;

class Solution {
    // 3324. Find the Sequence of Strings Appeared on the Screen
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        // Step 1: Append 'a' to the string until it matches the first character of target
        for (int i = 0; i < target.length(); i++) {
            // Add 'a' to the string
            current.append('a');
            result.add(current.toString());

            // Increment the last character until it matches the target's corresponding character
            while (current.charAt(i) < target.charAt(i)) {
                current.setCharAt(i, (char)(current.charAt(i) + 1));
                result.add(current.toString());
            }
        }

        return result;
    }
}
