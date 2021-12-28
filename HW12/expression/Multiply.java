package expression;

import java.math.BigInteger;

public class Multiply extends BinaryOperation {
    public Multiply(CommonExpression left, CommonExpression right) {
        super(left, right, "*");
    }

    @Override
    public int apply(int x, int y) {
        return x * y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public int getPriority() {
        return 2;
    }

    public int getSecondPriority() {
        return 13;
    }

    public boolean isInvert() {
        return false;
    }

}
