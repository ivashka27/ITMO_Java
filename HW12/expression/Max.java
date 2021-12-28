package expression;

import java.math.BigInteger;

public class Max extends BinaryOperation {
    public Max(CommonExpression left, CommonExpression right) {
        super(left, right, "max");
    }

    @Override
    public int apply(int x, int y) {
        return Math.max(x, y);
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.max(y);
    }

    public int getPriority() {
        return 0;
    }

    public int getSecondPriority() {
        return 3;
    }

    public boolean isInvert() {
        return false;
    }
}

