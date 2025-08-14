package io.github_spring_boot_studies.spring_architecture.montadora;

public class CarKey {
    private Automaker automaker;
    private String type;

    public CarKey(Automaker automaker, String type) {
        this.automaker = automaker;
        this.type = type;
    }

    public Automaker getAutomaker() {
        return automaker;
    }

    public void setAutomaker(Automaker automaker) {
        this.automaker = automaker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
