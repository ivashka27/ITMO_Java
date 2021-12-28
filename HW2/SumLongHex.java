public class SumLongHex {
    public static void main(String[] args) {
        long result = 0;
        for (int i = 0; i < args.length; i++) {
            int len = args[i].length();
            String str = args[i];
            for (int j = 0; j < len; j++) {
                if (Character.isWhitespace(str.charAt(j))) {
                    continue;
                }
                int firstPos = j;
                for (;j < len && !Character.isWhitespace(str.charAt(j));) {
                    j++;
                }
                String num = str.substring(firstPos, j);
                if (num.startsWith("0X") || num.startsWith("0x")) {
                    result += Long.parseUnsignedLong(num.substring(2), 16);
                } else {
                    result += Long.parseLong(num);
                }

            }
        }
        System.out.print(result);
    }
}