package expression;

import java.math.BigInteger;

public class Add extends BinaryOperation {

    public Add(CompositeExpression first, CompositeExpression second) {
        super(first, second, "+");
    }



    @Override
    public int apply(int x, int y) {
        return x + y;
    }

    public BigInteger apply(BigInteger x, BigInteger y) {
        return x.add(y);
    }


    public int getPriority() {
        return 0;
    }

    public boolean isInvert() {
        return false;
    }

    public int getSecondPriority() {
        return 5;
    }


}