package nl.benkhard.pactdemoprovider.domain;

public class Animal {
    private Long id;
    private String name;
    private boolean mammal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMammal() {
        return mammal;
    }

    public void setMammal(boolean mammal) {
        this.mammal = mammal;
    }
}
