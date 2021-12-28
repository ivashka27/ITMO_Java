package markup;
import java.util.List;

public class Emphasis extends AbstractClass implements MarkdownMethods {
    public void toMarkdown(StringBuilder s) {
        in(s, "*");
    }

    public void toBBCode(StringBuilder s) {
        inBBCode(s, "[i]", "[/i]");
    }

    public Emphasis(List<MarkdownMethods> input) {
        super(input);
    }
}
