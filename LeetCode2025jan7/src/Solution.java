import java.util.*;
//46. Permutations
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, result, used);
            current.remove(current.size() - 1); // Backtrack
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Permutations of " + Arrays.toString(nums1) + ": " + permute(nums1));

        int[] nums2 = {0, 1};
        System.out.println("Permutations of " + Arrays.toString(nums2) + ": " + permute(nums2));

        int[] nums3 = {1};
        System.out.println("Permutations of " + Arrays.toString(nums3) + ": " + permute(nums3));
    }
}
