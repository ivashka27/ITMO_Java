package expression;

import java.math.BigInteger;

public class Min extends BinaryOperation {
    public Min(CommonExpression left, CommonExpression right) {
        super(left, right, "min");
    }

    @Override
    public int apply(int x, int y) {
        return Math.min(x, y);
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.min(y);
    }

    public int getPriority() {
        return 0;
    }

    public int getSecondPriority() {
        return 2;
    }

    public boolean isInvert() {
        return false;
    }
}
