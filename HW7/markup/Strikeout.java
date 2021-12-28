package markup;
import java.util.List;

public class Strikeout extends AbstractClass implements MarkdownMethods {
    public void toMarkdown(StringBuilder s) {
        in(s, "~");
    }

    public void toBBCode(StringBuilder s) {
        inBBCode(s, "[s]", "[/s]");
    }

    public Strikeout(List<MarkdownMethods> input) {
        super(input);
    }
}