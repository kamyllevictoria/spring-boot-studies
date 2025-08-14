package io.github_spring_boot_studies.spring_architecture.montadora;

import java.awt.*;

public class Car {
    private String model;
    private Color color;
    private Double price;
    private Engine engine;
    private Automaker automaker;

    public Car(String model, Color color, Double price, Engine engine, Automaker automaker) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.engine = engine;
        this.automaker = automaker;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Automaker getAutomaker() {
        return automaker;
    }

    public void setAutomaker(Automaker automaker) {
        this.automaker = automaker;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color=" + color +
                ", price=" + price +
                ", engine=" + engine +
                ", automaker=" + automaker +
                '}';
    }

    public CarStatus getIgnite(CarKey carKey){
        if(carKey.getAutomaker() != this.automaker){
            return new CarStatus("Isnt possible to ignite the car with this key",
                    null);
        }
        return new CarStatus("Running with engine:",this.engine);
    }


}
