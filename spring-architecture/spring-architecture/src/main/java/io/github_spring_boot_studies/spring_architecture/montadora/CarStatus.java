package io.github_spring_boot_studies.spring_architecture.montadora;

public class CarStatus{
    private String message;
    private Engine engine;

    public CarStatus(String message, Engine engine) {
        this.message = message;
        this.engine = engine;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
