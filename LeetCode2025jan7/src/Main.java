import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

        //2974. Minimum Number Game
        Main game = new Main();

        int[] nums1 = {5, 4, 2, 3};
        System.out.println(Arrays.toString(game.numberGame(nums1))); // Output: [3, 2, 5, 4]

        int[] nums2 = {2, 5};
        System.out.println(Arrays.toString(game.numberGame(nums2))); // Output: [5, 2]

    }


    //2974. Minimum Number Game FUNCTION:
    public int[] numberGame(int[] nums) {
        // Sort the nums array in ascending order
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int arrIndex = 0;

        int left = 0, right = nums.length - 1;

        // Iterate through nums array, alternating Alice's and Bob's moves
        while (left <= right) {
            // Alice removes the smallest element
            int alicePick = nums[left++];
            // Bob removes the next smallest element
            int bobPick = nums[left++];

            // Bob appends first
            arr[arrIndex++] = bobPick;
            // Alice appends next
            arr[arrIndex++] = alicePick;
        }

        return arr;
    }




}