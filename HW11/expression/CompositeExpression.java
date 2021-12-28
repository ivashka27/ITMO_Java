package expression;

public interface CompositeExpression extends Expression, TripleExpression, BigIntegerExpression {
    int getPriority();
    int getSecondPriority();
    boolean isInvert();
}