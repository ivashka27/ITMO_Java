package markup;

public interface Element {
    public void toMarkdown(StringBuilder s);
    public void toBBCode(StringBuilder s);
}