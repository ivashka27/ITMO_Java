package expression;

import java.math.BigInteger;

public abstract class BinaryOperation implements CompositeExpression {

    protected CompositeExpression first, second;
    protected String type;
    protected Integer hash = null;

    public BinaryOperation(CompositeExpression first, CompositeExpression second, String type) {
        this.first = first;
        this.second = second;
        this.type = type;
    }

    private String makeString() {
        return "(" + first + " " + type + " " + second + ")";
    }

    @Override
    public String toString() {
        return makeString();
    }

    private void toBracketString(StringBuilder res, CompositeExpression op, boolean need) {
        if (need) {
            res.append("(").append(op.toMiniString()).append(")");
        } else {
            res.append(op.toMiniString());
        }
    }

    private String makeMiniString() {
        StringBuilder res = new StringBuilder();
        boolean firstHigh = this.getPriority() > first.getPriority(), secondHigh;

        if (this.getPriority() == second.getPriority()) {
            secondHigh = this.isInvert() || second.isInvert() && second.getSecondPriority() != this.getSecondPriority();
        } else {
            secondHigh = this.getPriority() > second.getPriority();
        }

        toBracketString(res, first, firstHigh);
        res.append(" ").append(type).append(" ");
        toBracketString(res, second, secondHigh);
        return res.toString();
    }

    public String toMiniString() {
        return makeMiniString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        BinaryOperation curOperation = (BinaryOperation) o;

        return curOperation.first.equals(this.first) && curOperation.second.equals(this.second);
    }

    protected abstract int apply(int x, int y);

    protected abstract BigInteger apply(BigInteger x, BigInteger y);

    public int evaluate(int x) {
        return apply(first.evaluate(x), second.evaluate(x));
    }

    public BigInteger evaluate(BigInteger x) {
        return apply(first.evaluate(x), second.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return apply(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    @Override
    public int hashCode() {
        if (hash != null) {
            return hash;
        }
        return hash = 47 * first.hashCode() + 79 * second.hashCode() + 119 * getClass().hashCode();
    }
}