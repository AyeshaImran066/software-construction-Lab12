package expressivo;

import java.util.Objects;

public final class Add implements Expression {

    private final Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = Objects.requireNonNull(left);
        this.right = Objects.requireNonNull(right);
    }

    public Expression left() { return left; }
    public Expression right() { return right; }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Add)) return false;
        Add a = (Add) o;
        return left.equals(a.left) && right.equals(a.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash("+", left, right);
    }
}
