package expression;

public interface CommonExpression extends Expression, TripleExpression, BigIntegerExpression {
    boolean equals(Object obj);
    String toString();
    int getPriority();
    int getSecondPriority();
    boolean isInvert();
    int hashCode();
}
