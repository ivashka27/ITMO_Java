package markup;
import java.util.List;

public class Strong extends AbstractClass implements MarkdownMethods{
    @Override
    public void toMarkdown(StringBuilder s) {
        in(s, "__");
    }

    @Override
    public void toBBCode(StringBuilder s) {
        inBBCode(s, "[b]", "[/b]");
    }

    public Strong(List<MarkdownMethods> input) {
        super(input);
    }

}