import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

public class ReverseMin2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] all = new int[1][];
        int strPos = 0, maxLen = 0, numPos;

        while (in.hasNextLine()) {
            Scanner str = new Scanner(in.nextLine());
            numPos = 0;

            int[] nums = new int[1];
            while (str.hasNextInt()) {
                if (numPos == nums.length) {
                    nums = Arrays.copyOf(nums, nums.length * 2);
                }
                nums[numPos++] = str.nextInt();
            }
            nums = Arrays.copyOf(nums, numPos);

            if (strPos == all.length) {
                all = Arrays.copyOf(all, all.length * 2);
            }
            maxLen = Math.max(maxLen, nums.length);
            all[strPos++] = nums;
        }

        all = Arrays.copyOf(all, strPos);

        int[] minInCol = new int[maxLen];
        Arrays.fill(minInCol, Integer.MAX_VALUE);

        for (int[] line : all) {
            for (int i = 0; i < line.length; i++) {
                if (i != 0)
                    minInCol[i] = Math.min(minInCol[i], minInCol[i - 1]);
                minInCol[i] = Math.min(minInCol[i], line[i]);
                System.out.print(minInCol[i] + " ");
            }
            System.out.println();
        }
    }
}