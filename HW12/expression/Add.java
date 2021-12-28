package expression;

import java.math.BigInteger;

public class Add extends BinaryOperation {
    public Add(CommonExpression left, CommonExpression right) {
        super(left, right, "+");
    }

    @Override
    public int apply(int x, int y) {
        return x + y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    public int getPriority() {
        return 1;
    }

    public int getSecondPriority() {
        return 120;
    }

    public boolean isInvert() {
        return false;
    }
}
