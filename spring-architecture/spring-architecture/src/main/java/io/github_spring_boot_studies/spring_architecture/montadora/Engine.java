package io.github_spring_boot_studies.spring_architecture.montadora;


public class Engine {
    private String model;
    private Integer horses;
    private Integer cylinders;
    private Double liters;
    private TypeCarMotor typeCarMotor;//injecao de dependencia

    public Engine(String model, Integer horses, Integer cylinders, Double liters, TypeCarMotor typeCarMotor) {
        this.model = model;
        this.horses = horses;
        this.cylinders = cylinders;
        this.liters = liters;
        this.typeCarMotor = typeCarMotor;
    }

    public Engine() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorses() {
        return horses;
    }

    public void setHorses(Integer horses) {
        this.horses = horses;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double liters) {
        this.liters = liters;
    }

    public TypeCarMotor getTypeEngine() {
        return typeCarMotor;
    }

    public void setTypeEngine(TypeCarMotor typeCarMotor) {
        this.typeCarMotor = typeCarMotor;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", horses=" + horses +
                ", cylinders=" + cylinders +
                ", liters=" + liters +
                ", typeCarMotor=" + typeCarMotor +
                '}';
    }
}
