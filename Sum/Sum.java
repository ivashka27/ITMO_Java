public class Sum {
    public static void main(String[] args) {
        int result = 0;
        int N = args.length;
        for (String str : args) {
            String regex = "\\p{javaWhitespace}";
            String curr = str.replaceAll(regex, " ").strip();
            String[] processed_nums = curr.split(" ");
            for (String elem : processed_nums) {
                if (elem.length() == 0) {
                    continue;
                }
                int num = new Integer(elem);
                result += num;
            }
        }

        System.out.print(result);
    }
}
