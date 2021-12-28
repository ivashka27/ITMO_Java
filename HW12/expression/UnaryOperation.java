package expression;

import java.math.BigInteger;
import java.util.Objects;

public abstract class UnaryOperation implements CommonExpression {
    protected CommonExpression value;
    protected final String type;

    public UnaryOperation(CommonExpression value, String type) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return type + '(' + value.toString() + ')';
    }

    public String toMiniString() {
        if (value instanceof Variable || value instanceof Const || value instanceof UnaryOperation) {
            return type + " " + value.toMiniString();
        }
        return type + "(" + value.toMiniString() + ")";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass().equals(obj.getClass())) {
            UnaryOperation other = (UnaryOperation) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    protected abstract int apply(int x);
    protected abstract BigInteger apply(BigInteger x);

    @Override
    public int evaluate(int x) {
        return apply(value.evaluate(x));
    }

    public BigInteger evaluate(BigInteger x) {
        return apply(value.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return apply(value.evaluate(x, y, z));
    }

    @Override
    public int hashCode() {
        return 424241 * value.hashCode() + 37 * this.type.hashCode() + 41 * value.hashCode();
    }
}
