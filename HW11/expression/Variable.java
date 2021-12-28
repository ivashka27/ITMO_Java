package expression;

import java.math.BigInteger;
import java.util.NoSuchElementException;

public class Variable implements CompositeExpression {

    private final String arg;

    public Variable(String arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return arg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        return ((Variable) o).arg.equals(this.arg);
    }

    @Override
    public int evaluate(int x) {
        return x;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        if ("x".equals(this.arg)) {
            return x;
        } else if ("y".equals(this.arg)) {
            return y;
        } else if ("z".equals(this.arg)) {
            return z;
        } else {
            throw new NoSuchElementException("That wasn't x/y/z argument");
        }
    }

    public BigInteger evaluate(BigInteger x) {
        return x;
    }

    public int getPriority() {
        return 5;
    }

    public boolean isInvert() {
        return false;
    }

    public int getSecondPriority() {
        return 2;
    }


    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}