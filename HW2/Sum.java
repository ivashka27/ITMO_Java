public class Sum {
    public static void main(String[] args) {
        int result = 0;
        int N = args.length;
        for (String str : args) {
            int pos_first = -1;
            int len = str.length();
            for (int pos_second = 0; pos_second < len; pos_second++) {
                if (!Character.isWhitespace(str.charAt(pos_second))) {
                    if (pos_first == -1) {
                        pos_first = pos_second;
                    }
                } else if (pos_first != -1) {
                    String curr = str.substring(pos_first, pos_second);
                    int num = Integer.parseInt(curr);
                    result += num;
                    pos_first = -1;
                }
            }
            if (pos_first != -1) {
                String curr = str.substring(pos_first);
                int num = Integer.parseInt(curr);
                result += num;
            }
        }

        System.out.print(result);
    }
}