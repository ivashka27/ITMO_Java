package markup;
import java.util.List;

public abstract class AbstractClass implements Element {
    protected List<? extends Element> input;

    protected AbstractClass(List<? extends Element> input) {
        this.input = input;
    }

    protected void in(StringBuilder s, String mark) {
        s.append(mark);
        for (int i = 0; i < input.size(); i++) {
            input.get(i).toMarkdown(s);
        }
        s.append(mark);
    }

    protected void inBBCode(StringBuilder s, String left, String right) {
        s.append(left);
        for (int i = 0; i < input.size(); i++) {
            input.get(i).toBBCode(s);
        }
        s.append(right);
    }

    abstract public void toMarkdown(StringBuilder s);

    abstract public void toBBCode(StringBuilder s);

}