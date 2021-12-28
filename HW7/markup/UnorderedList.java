package markup;

import java.util.List;

public class UnorderedList extends AbstractClass implements ListMethods {
    public UnorderedList(List<ListItem> input) {
        super(input);
    }

    @Deprecated
    @Override
    public void toMarkdown(StringBuilder sb) {
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        inBBCode(sb, "[list]", "[/list]");
    }
}