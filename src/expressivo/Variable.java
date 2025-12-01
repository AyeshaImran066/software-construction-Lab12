package expressivo;

import java.util.Objects;

public final class Variable implements Expression {

    private final String name;

    public Variable(String name) {
        if (!name.matches("[A-Za-z]+"))
            throw new IllegalArgumentException("Invalid variable");
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Variable) && ((Variable)o).name.equals(this.name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }
}