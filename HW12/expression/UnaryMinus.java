package expression;

import java.math.BigInteger;

public class UnaryMinus extends UnaryOperation {
    public UnaryMinus(CommonExpression value) {
        super(value, "-");
    }

    @Override
    public int apply(int x) {
        return -x;
    }

    public BigInteger apply(BigInteger x) {
        return x.multiply(BigInteger.valueOf(-1));
    }

     public int getPriority() {
         return 10;
     }

     public int getSecondPriority() {
         return 4;
     }

     public boolean isInvert() {
         return false;
     }

}
