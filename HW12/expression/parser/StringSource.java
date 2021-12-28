package expression.parser;

public class StringSource implements Source {
    private final String line;
    private int position;

    public StringSource(String line) {
        this.line = line;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < line.length();
    }

    @Override
    public char next() {
        return line.charAt(position++);
    }
}