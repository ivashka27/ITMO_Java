package expression;

import java.math.BigInteger;
import java.util.NoSuchElementException;

public class Variable implements CommonExpression {
    private final String value;

    public Variable(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        return ((Variable) o).value.equals(this.value);
    }

    @Override
    public int evaluate(int x) {
        return x;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        if ("x".equals(this.value)) {
            return x;
        } else if ("y".equals(this.value)) {
            return y;
        } else if ("z".equals(this.value)) {
            return z;
        } else {
            throw new NoSuchElementException("That wasn't x/y/z argument");
        }
    }

    public BigInteger evaluate(BigInteger x) {
        return x;
    }

    public int getPriority() {
        return 9;
    }

    public int getSecondPriority() {
        return 81;
    }

    public boolean isInvert() {
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
