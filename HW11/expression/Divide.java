package expression;

import java.math.BigInteger;

public class Divide extends BinaryOperation {

    public Divide(CompositeExpression first, CompositeExpression second) {
        super(first, second, "/");
    }

    @Override
    public int apply(int x, int y) {
        return x / y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.divide(y);
    }

    public int getPriority() {
        return 4;
    }

    public boolean isInvert() {
        return true;
    }

    public int getSecondPriority() {
        return 0;
    }

}