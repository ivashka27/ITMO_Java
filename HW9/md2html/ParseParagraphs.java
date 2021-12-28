package md2html;

public class ParseParagraphs {
    private StringBuilder sb;

    public ParseParagraphs(StringBuilder sb) {
        this.sb = sb;
    }

    public void toHtml(StringBuilder processed) {
        processed.append("<p>");
        new ParseTexts(sb).toHtml(processed);
        processed.append("</p>");
    }
}