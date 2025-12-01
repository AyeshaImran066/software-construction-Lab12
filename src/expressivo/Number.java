package expressivo;

import java.util.Objects;

public final class Number implements Expression {

    private final double value;

    public Number(double value) {
        this.value = value;
    }

    public double getValue() { return value; }

    @Override
    public String toString() {
        return Double.toString(value); // always produce decimal
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number)) return false;
        Number n = (Number) o;
        return Math.abs(this.value - n.value) < 1e-9;
    }

    @Override
    public int hashCode() {
        long scaled = Math.round(value * 1e9);
        return Long.hashCode(scaled);
    }
}