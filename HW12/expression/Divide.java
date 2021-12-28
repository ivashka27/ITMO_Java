package expression;

import java.math.BigInteger;

public class Divide extends BinaryOperation {
    public Divide(CommonExpression left, CommonExpression right) {
        super(left, right, "/");
    }

    @Override
    public int apply(int x, int y) {
        return x / y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.divide(y);
    }

    public int getPriority() {
        return 2;
    }

    public int getSecondPriority() {
        return 17;
    }

    public boolean isInvert() {
        return true;
    }

}
