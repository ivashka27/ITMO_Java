/*import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.Math;

public class ReverseMin2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();

        int prev = 0;
        int last = 0;
        int cnt = 0;
        while (in.hasNextLine()) {
            Scanner curr = new Scanner(in.nextLine());
            int len = 0;
            while (curr.hasNextInt()) {
                int num = curr.nextInt();
                if (cnt == 0) {
                    if (len == 0) {
                        nums.add(num);
                    } else {
                        nums.add(Math.min(num, nums.get(nums.size() - 1)));
                    }
                } else {
                    if (cnt == 1) {
                        num = Math.min(nums.get(len), num);
                    } else {
                        num = Math.min(nums.get(prev + len), num);
                    }
                    if (len == 0) {
                        nums.add(num);
                    } else {
                        nums.add(Math.min(num, nums.get(nums.size() - 1)));
                    }
                }
                len++;
            }
            if (len == 0) {
                lens.add(len);
                continue;
            }
            if (cnt == 0) {
                lens.add(len);
            } else {
                lens.add(last + len);
            }
            prev = last;
            last += len;
            cnt++;
        }

        prev = 0;
        last = 0;
        for (int i = 0;  i < lens.size(); i++) {
            if (lens.get(i) == 0) {
                System.out.println();
                continue;
            }
            prev = last;
            last = lens.get(i);
            for (int j = prev; j < last; j++) {
                System.out.print(nums.get(j) + " ");
            }
            System.out.println();
        }
    }
}*/

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.min;

public class ReverseMin2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] data = new int[1][];
        int dataIndex = 0;
        int maxLineLength = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner sc = new Scanner(line);
            int[] numbers = new int[1];
            int numbersIndex = 0;
            while (sc.hasNextInt()) {
                if (numbersIndex >= numbers.length) {
                    numbers = Arrays.copyOf(numbers, numbers.length * 2);
                }
                numbers[numbersIndex] = sc.nextInt();
                numbersIndex++;
            }
            numbers = Arrays.copyOf(numbers, numbersIndex);
            sc.close();
            if (dataIndex >= data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            maxLineLength = Math.max(maxLineLength, numbers.length);
            data[dataIndex] = numbers;
            dataIndex++;
        }
        data = Arrays.copyOf(data, dataIndex);
        in.close();
        int[] columnMins = new int[maxLineLength];
        Arrays.fill(columnMins, Integer.MAX_VALUE);
        for (int[] line: data) {
            if (line.length == 0){
                System.out.println();
                continue;
            }
            for (int i = 0; i < line.length; i++) {
                if (i > 0) {
                    columnMins[i] = min(columnMins[i], columnMins[i - 1]);
                }
                columnMins[i] = min(columnMins[i], line[i]);
                System.out.print(columnMins[i] + " ");
            }
            System.out.println();
        }
    }
}