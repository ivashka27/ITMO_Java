package markup;

public class Text implements MarkdownMethods {
    private String s;

    public Text(String s) {
        this.s = s;
    }

    public void toMarkdown(StringBuilder str) {
        str.append(s);
    }

    public void toBBCode(StringBuilder str) {
        str.append(s);
    }
}