package expression;

import java.math.BigInteger;

public class T0 extends UnaryOperation {
    public T0(CommonExpression value) {
        super(value, "t0");
    }

    @Override
    public int apply(int x) {
        return Integer.numberOfTrailingZeros(x);
    }

    public BigInteger apply(BigInteger x) {
        int res = 0;
        while (!x.equals(BigInteger.ZERO)) {
            x = x.divide(BigInteger.TWO);
            res++;
        }
        return BigInteger.valueOf(res);
    }


    public int getPriority() {
        return 10;
    }

    public int getSecondPriority() {
        return 1;
    }

    public boolean isInvert() {
        return false;
    }

}
