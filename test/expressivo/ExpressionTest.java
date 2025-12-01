package expressivo;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testNumber() {
        Expression n1 = new Number(5);
        Expression n2 = new Number(5.0);
        Expression n3 = new Number(3);

        assertEquals("5.0", n1.toString());
        assertTrue(n1.equals(n2));
        assertFalse(n1.equals(n3));
        assertEquals(n1.hashCode(), n2.hashCode());
    }

    @Test
    public void testVariable() {
        Expression x1 = new Variable("x");
        Expression x2 = new Variable("x");
        Expression y = new Variable("y");

        assertEquals("x", x1.toString());
        assertTrue(x1.equals(x2));
        assertFalse(x1.equals(y));
        assertEquals(x1.hashCode(), x2.hashCode());
    }

    // ---- Add tests ----
    @Test
    public void testAddBasics() {
        Expression e1 = new Add(new Number(1), new Variable("x"));
        Expression e2 = new Add(new Number(1), new Variable("x"));
        Expression e3 = new Add(new Variable("x"), new Number(1));

        assertEquals("(1.0 + x)", e1.toString());
        assertTrue(e1.equals(e2));
        assertFalse(e1.equals(e3)); // order matters
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    // ---- Nested Add expressions ----
    @Test
    public void testNestedAdd() {
        Expression inner = new Add(new Number(2), new Variable("y"));
        Expression outer = new Add(new Number(1), inner);
        Expression sameOuter = new Add(new Number(1), new Add(new Number(2), new Variable("y")));

        assertEquals("(1.0 + (2.0 + y))", outer.toString());
        assertTrue(outer.equals(sameOuter));
        assertEquals(outer.hashCode(), sameOuter.hashCode());
    }
}
