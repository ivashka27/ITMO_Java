package expression.parser;

public abstract class BaseParser {
    private final Source source;
    protected char c;

    public BaseParser(final Source source) {
        this.source = source;
    }

    protected void nextChar() {
        c = (source.hasNext()) ? source.next() : '?';
    }

    protected void skipWhiteSpace() {
        while(Character.isWhitespace(c)) {
            test(c);
        }
    }

    protected boolean test(char testValue) {
        if (c == testValue) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean isDigit() {
        return c >= '0' && c <= '9';
    }

    protected boolean isVariable() {
        return c == 'x' || c == 'y' || c == 'z';
    }
}