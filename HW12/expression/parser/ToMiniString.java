package expression.parser;

public interface ToMiniString {
    default String toMiniString() {
        return toString();
    }
}