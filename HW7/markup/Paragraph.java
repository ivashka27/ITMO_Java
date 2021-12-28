package markup;
import java.util.List;

public class Paragraph extends AbstractClass implements ListMethods{
    public void toMarkdown(StringBuilder s) {
        in(s, "");
    }

    public void toBBCode(StringBuilder s) {
        inBBCode(s, "", "");
    }

    public Paragraph(List<MarkdownMethods> input) {
        super(input);
    }

}
