package md2html;

public class ParseHeaders {
    private StringBuilder sb;

    ParseHeaders(StringBuilder sb) {
        this.sb = sb;
    }

    private int levelHeader(StringBuilder str) {
        int idx = 0;
        while (idx < str.length() && str.charAt(idx) == '#') {
            idx++;
        }
        return idx;
    }
    public void toHtml(StringBuilder processed) {
        int l = levelHeader(sb);
        processed.append("<h").append(l).append(">");
        new ParseTexts(new StringBuilder(sb.substring(l + 1))).toHtml(processed);
        processed.append("</h").append(l).append(">");
    }
}