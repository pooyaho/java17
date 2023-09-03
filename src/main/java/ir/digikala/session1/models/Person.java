package ir.digikala.session1.models;

public abstract class Person {
    private String name;
    private Long id;
    private String nationalCode;
    private String family;

    public Person() {
    }

    public Person(String name, Long id, String nationalCode, String family) {
        this.name = name;
        this.id = id;
        this.nationalCode = nationalCode;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
