import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>(), lens = new ArrayList<>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int countNums = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ' ') {
                    continue;
                }
                int i = j;
                while (j < str.length() && str.charAt(j) != ' ') {
                    j++;
                    //System.out.println(j);
                }
                countNums++;
                nums.add(Integer.parseInt(str.substring(i, j)));
            }
            lens.add(countNums);
        }
        in.close();

        int numPos = nums.size() - 1;

        for (int i = lens.size() - 1;  i > -1; i--) {
            for (int j = 0; j < lens.get(i); j++) {
                System.out.print(nums.get(numPos) + " ");
                numPos--;
            }
            System.out.println();
        }

    }
}
