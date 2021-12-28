package markup;

import java.util.List;

public class ListItem extends AbstractClass {
    public ListItem(List<ListMethods> input) {
        super(input);
    }

    @Deprecated
    @Override
    public void toMarkdown(StringBuilder s) {

    }

    @Override
    public void toBBCode(StringBuilder s) {
        inBBCode(s, "[*]", "");
    }

}
