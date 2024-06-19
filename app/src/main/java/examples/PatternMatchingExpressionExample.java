package examples;

public class PatternMatchingExpressionExample {

    // Define an interface and classes for the AST
    interface Expr {
    }

    class Add implements Expr {
        Expr lhs, rhs;

        Add(Expr lhs, Expr rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }

    class Multiply implements Expr {
        Expr lhs, rhs;

        Multiply(Expr lhs, Expr rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }

    class Literal implements Expr {
        int value;

        Literal(int value) {
            this.value = value;
        }
    }

    public static int eval(Expr expr) {
        if (expr instanceof Add) {
            Add add = (Add) expr;
            return eval(add.lhs) + eval(add.rhs);
        } else if (expr instanceof Multiply) {
            Multiply multiply = (Multiply) expr;
            return eval(multiply.lhs) * eval(multiply.rhs);
        } else if (expr instanceof Literal) {
            Literal lit = (Literal) expr;
            return lit.value;
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
    }

    public static String describe(Expr expr) {
        if (expr instanceof Add) {
            Add add = (Add) expr;
            return "(" + describe(add.lhs) + " + " + describe(add.rhs) + ")";
        } else if (expr instanceof Multiply) {
            Multiply mul = (Multiply) expr;
            return "(" + describe(mul.lhs) + " * " + describe(mul.rhs) + ")";
        } else if (expr instanceof Literal) {
            Literal lit = (Literal) expr;
            return Integer.toString(lit.value);
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
    }

    public static void main(String[] args) {
        PatternMatchingExpressionExample prog = new PatternMatchingExpressionExample();
        prog.start();
    }

    public void start() {
        // can now access non-static fields
        Expr expr = new Add(new Multiply(new Literal(2), new Literal(3)), new Add(new Literal(4), new Literal(5)));
        System.out.println(describe(expr));  // Output: ((2 * 3) + (4 + 5))
        System.out.println(eval(expr));      // Output: 11
    }

}


