package expression;

import java.math.BigInteger;

public class L0 extends UnaryOperation {
    public L0(CommonExpression value) {
        super(value, "l0");
    }

    @Override
    public int apply(int x) {
        return Integer.numberOfLeadingZeros(x);
    }

    public BigInteger apply(BigInteger x) {
        return null;
    }

    public int getPriority() {
        return 10;
    }

    public int getSecondPriority() {
        return 0;
    }

    public boolean isInvert() {
        return false;
    }


}
