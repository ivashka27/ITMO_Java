package md2html;

public class ParseBlocks {
    private StringBuilder sb;

    public ParseBlocks(StringBuilder sb) {
        this.sb = sb;
    }

    private boolean checkHeader(StringBuilder str) {
        int idx = 0;
        while (idx < str.length() && str.charAt(idx) == '#') {
            idx++;
        }
        return idx > 0 && idx < str.length() && str.charAt(idx) == ' ';
    }

    public void toHtml(StringBuilder processed) {
        if (checkHeader(sb)) {
            new ParseHeaders(sb).toHtml(processed);
        } else {
            new ParseParagraphs(sb).toHtml(processed);
        }
    }
}