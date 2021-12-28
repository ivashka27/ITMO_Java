package expression;

import java.math.BigInteger;

public class Subtract extends BinaryOperation {

    public Subtract(CompositeExpression first, CompositeExpression second) {
        super(first, second, "-");
    }


    @Override
    public int apply(int x, int y) {
        return x - y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }


    public int getPriority() {
        return 0;
    }

    public boolean isInvert() {
        return true;
    }

    public int getSecondPriority() {
        return 5;
    }


}