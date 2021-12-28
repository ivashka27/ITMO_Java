package expression;

import java.math.BigInteger;
import java.util.Objects;

public abstract class BinaryOperation implements CommonExpression {
    protected CommonExpression left;
    protected CommonExpression right;
    protected final String type;

    public BinaryOperation(CommonExpression left, CommonExpression right, String type) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return '(' + left.toString() + " " + type + " " + right.toString() + ')';
    }

    private void toBracketString(StringBuilder res, CommonExpression op, boolean need) {
        if (need) {
            res.append("(").append(op.toMiniString()).append(")");
        } else {
            res.append(op.toMiniString());
        }
    }

    private String makeMiniString() {
        StringBuilder res = new StringBuilder();
        boolean firstHigh = this.getPriority() > left.getPriority(), secondHigh;

        if (this.getPriority() == right.getPriority()) {
            secondHigh = this.isInvert() || right.isInvert() && right.getSecondPriority() != this.getSecondPriority();
        } else {
            secondHigh = this.getPriority() > right.getPriority();
        }

        toBracketString(res, left, firstHigh);
        res.append(" ").append(type).append(" ");
        toBracketString(res, right, secondHigh);
        return res.toString();
    }

    public String toMiniString() {
        return makeMiniString();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass().equals(obj.getClass())) {
            BinaryOperation other = (BinaryOperation) obj;
            return Objects.equals(this.left, other.left) && Objects.equals(this.right, other.right);
        }
        return false;
    }

    protected abstract int apply(int x, int y);

    protected abstract BigInteger apply(BigInteger x, BigInteger y);

    public int evaluate(int x) {
        return apply(left.evaluate(x), right.evaluate(x));
    }

    public BigInteger evaluate(BigInteger x) {
        return apply(left.evaluate(x), right.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return apply(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    @Override
    public int hashCode() {
        return 47 * left.hashCode() + 79 * right.hashCode() + 119 * getClass().hashCode();
    }
}