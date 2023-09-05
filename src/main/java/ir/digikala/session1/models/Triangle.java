package ir.digikala.session1.models;

public class Triangle extends Shape {

    private Long b;
    private Long c;

    public Triangle() {
        this(null, null, null);
    }

    public Triangle(Long a, Long b, Long c) {
        setA(a);
        this.b = b;
        this.c = c;
    }

    public Long getB() {
        return b;
    }

    public void setB(Long b) {
        this.b = b;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }
}
