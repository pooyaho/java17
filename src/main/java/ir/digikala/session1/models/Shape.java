package ir.digikala.session1.models;

public abstract class Shape {
    private Long a;

    public Shape(Long a) {
        this.a = a;
    }

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }
}
