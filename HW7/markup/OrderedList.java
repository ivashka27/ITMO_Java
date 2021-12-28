package markup;

import java.util.List;

public class OrderedList extends AbstractClass implements ListMethods {
    public OrderedList(List<ListItem> content) {
        super(content);
    }

    @Deprecated
    @Override
    public void toMarkdown(StringBuilder sb) {
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        inBBCode(sb, "[list=1]", "[/list]");
    }
}