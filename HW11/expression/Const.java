package expression;

import java.math.BigInteger;

public class Const implements CompositeExpression {

    private final BigInteger value;


    public Const(int value) { this.value = BigInteger.valueOf(value); }
    public Const(BigInteger value) {this.value = value;}



    @Override
    public int evaluate(int x) {
        return value.intValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }


    public BigInteger evaluate(BigInteger x) {
        return value;
    }


    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Const c = (Const) o;
        return c.value.equals(value);
    }

    public int getPriority() {
        return 5;
    }

    public boolean isInvert() {
        return false;
    }

    public int getSecondPriority() {
        return 1;
    }


    @Override
    public int hashCode() {
        return value.intValue();
    }
}