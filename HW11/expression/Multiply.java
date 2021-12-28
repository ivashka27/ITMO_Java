package expression;

import java.math.BigInteger;

public class Multiply extends BinaryOperation {

    public Multiply(CompositeExpression first, CompositeExpression second) {
        super(first, second, "*");
    }

    @Override
    public int apply(int x, int y) {
        return x * y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public int getPriority() {
        return 4;
    }

    public boolean isInvert() {
        return false;
    }

    public int getSecondPriority() {
        return 3;
    }

}